package com.codeclan.example.scotsservice.repository;

import com.codeclan.example.scotsservice.models.Scot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ScotRepository extends JpaRepository<Scot, Long> {


    @Query(value = "SELECT DISTINCT (occupation) FROM scots", nativeQuery = true)
    List<String> findAllOccupations();

    @Query(value = "SELECT COUNT(occupation) FROM scots WHERE occupation=:occupation", nativeQuery = true)
    int findOccupationCount(@Param("occupation") String occupation);

//    @Query(value = "SELECT (occupation) FROM scots WHERE GROUP BY occupation ORDER BY COUNT (occupation) DESC", nativeQuery = true)
//    List<String> findOccupationsByCount();

    @Query(value = "SELECT (occupation) FROM scots GROUP BY occupation HAVING COUNT(occupation) > 10 ORDER BY COUNT (occupation) DESC", nativeQuery = true)
    List<String> findOccupationsByCount();


//    SELECT name, COUNT(*)
//    FROM mytable
//    GROUP BY name
//    HAVING COUNT(*) > 1

    @Query(value = "SELECT * FROM Scots WHERE occupation=:occupation ORDER BY name", nativeQuery = true)
    List<Scot> findByOccupation(@Param("occupation") String occupation);


}
