package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaueService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("speed punch");
        skills.add("low kick");
        skills.add("upper cut");

        return skills;
    }

}
