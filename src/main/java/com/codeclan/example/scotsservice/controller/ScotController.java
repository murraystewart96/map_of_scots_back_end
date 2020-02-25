package com.codeclan.example.scotsservice.controller;

import com.codeclan.example.scotsservice.helpers.Helper;
import com.codeclan.example.scotsservice.models.Scot;
import com.codeclan.example.scotsservice.repository.ScotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ScotController {

    @Autowired
    ScotRepository scotRepository;


    @GetMapping(value = "/scots/{id}")
    public ResponseEntity getScot(@PathVariable Long id){
        return new ResponseEntity(scotRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/scots/occupations/{occupation}")
    public ResponseEntity<List<Scot>> getAllScots(@PathVariable String occupation){
        Helper helper = new Helper();
        List<Scot> returnedScots = scotRepository.findByOccupation(occupation);
        ArrayList<Scot> distinctScots = helper.removeDuplicates(returnedScots);
        return new ResponseEntity<>(distinctScots, HttpStatus.OK);
    }

    @GetMapping(value = "/scots/{occupation}/{gender}")
    public ResponseEntity<List<Scot>> getScotsByOccupationAndGender(@PathVariable String occupation, @PathVariable String gender){
        Helper helper = new Helper();
        List<Scot> returnedScots = scotRepository.findByOccupationAndGender(occupation, gender);
        ArrayList<Scot> distinctScots = helper.removeDuplicates(returnedScots);
        return new ResponseEntity<>(distinctScots, HttpStatus.OK);
    }


    @GetMapping(value = "/occupations")
    public ResponseEntity<List<String>> getAllOccupations(){
        return new ResponseEntity<>(scotRepository.findOccupationsByCount(), HttpStatus.OK);
    }

    @GetMapping(value = "/names")
    public ResponseEntity<List<Scot>> getNamesOfScots(){
        Helper helper = new Helper();
        List<Scot> returnedScots = scotRepository.findAllScotsOrderedByName();
       // ArrayList<Scot> distinctScots = helper.removeDuplicates(returnedScots);
        return new ResponseEntity<>(returnedScots, HttpStatus.OK);
    }



    @PostMapping(value = "/scots")
    public ResponseEntity<List<Scot>> addScot(@RequestBody ArrayList<Scot> scots){

        for(int i = 0; i < scots.size(); i++){
            System.out.println(scots.get(i).getName());
            scotRepository.save(scots.get(i));
        }
        List<String> occupations = scotRepository.findAllOccupations();

        return new ResponseEntity<>(scots, HttpStatus.CREATED);
    }
}
