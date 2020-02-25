package com.codeclan.example.scotsservice.components;

import com.codeclan.example.scotsservice.helpers.Helper;
import com.codeclan.example.scotsservice.models.Scot;
import com.codeclan.example.scotsservice.repository.ScotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ScotRepository scotRepository;

    public void run(ApplicationArguments args) {
//        List<String> occupations = scotRepository.findOccupationsByCount();
//
//        for(int i = 0; i < occupations.size(); i++){
//           {
//                System.out.println(occupations.get(i));
//
//            }
//        }
//
//
////Get scots by occupation and remove duplicates
//            List<Scot> scots = scotRepository.findByOccupation("physicist");
//        Helper helper = new Helper();
//        ArrayList<Scot> distinctScots = helper.removeDuplicates(scots);
//
//        for(int i = 0; i < distinctScots.size(); i++){
//            System.out.println(i + ": " + distinctScots.get(i).getName());
//            System.out.println(distinctScots.get(i).getPageID());
//        }
//    }

       List<Long> counts = scotRepository.findOccupationCounts();







        for(int i = 0; i < counts.size(); i++){
            System.out.println(i + ": " + counts.get(i));
            //System.out.println(distinctScots.get(i).getPageID());
       }

    }
}

