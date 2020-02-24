package com.codeclan.example.scotsservice.controller;

import com.codeclan.example.scotsservice.models.Scot;
import com.codeclan.example.scotsservice.repository.ScotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ScotController {

    @Autowired
    ScotRepository scotRepository;

    @GetMapping(value = "/scots/{occupation}")
    public ResponseEntity<List<Scot>> getAllScots(@PathVariable String occupation){
        return new ResponseEntity<>(scotRepository.findByOccupation(occupation), HttpStatus.OK);
    }


    @GetMapping(value = "/occupations")
    public ResponseEntity<List<String>> getAllOccupations(){
        return new ResponseEntity<>(scotRepository.findOccupationsByCount(), HttpStatus.OK);
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
