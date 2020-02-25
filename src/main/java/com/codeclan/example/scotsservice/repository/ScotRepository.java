package com.codeclan.example.scotsservice.repository;

import com.codeclan.example.scotsservice.models.Scot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScotRepository extends JpaRepository<Scot, Long> {


    @Query(value = "SELECT DISTINCT (occupation) FROM scots", nativeQuery = true)
    List<String> findAllOccupations();

   // @Query(value = "SELECT * FROM scots WHERE id=:id")
     Optional<Scot> findById(Long id);

    @Query(value = "SELECT COUNT(occupation) FROM scots WHERE occupation=:occupation", nativeQuery = true)
    int findOccupationCount(@Param("occupation") String occupation);

    @Query(value = "SELECT (occupation) FROM scots GROUP BY occupation HAVING COUNT(occupation) > 10 ORDER BY COUNT (occupation) DESC", nativeQuery = true)
    List<String> findOccupationsByCount();

    @Query(value = "SELECT * FROM Scots WHERE occupation=:occupation AND gender=:gender ORDER BY name", nativeQuery = true)
    List<Scot> findByOccupationAndGender(@Param("occupation") String occupation, @Param("gender") String gender);


    @Query(value = "SELECT * FROM Scots WHERE occupation=:occupation ORDER BY name", nativeQuery = true)
    List<Scot> findByOccupation(@Param("occupation") String occupation);

    @Query(value = "SELECT * FROM scots ORDER BY LOWER (name)", nativeQuery = true)
    List<Scot> findAllScotsOrderedByName();


}
