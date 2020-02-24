package com.codeclan.example.scotsservice.helpers;

import com.codeclan.example.scotsservice.models.Scot;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public ArrayList<Scot> removeDuplicates(List<Scot> scots){

        ArrayList<Scot> distinctScots = new ArrayList<>();

        for(int i = 0; i < scots.size() -1; i++){

            if(scots.get(i).getPageID().compareTo(scots.get(i+1).getPageID()) != 0){
                distinctScots.add(scots.get(i));
            }
        }
        return distinctScots;
    }
}
