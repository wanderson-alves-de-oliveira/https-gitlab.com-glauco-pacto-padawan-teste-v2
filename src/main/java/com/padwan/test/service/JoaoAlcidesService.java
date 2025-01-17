package com.padwan.test.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoaoAlcidesService {

    public List<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add("super strength");
        skills.add("invisibility");
        skills.add("telekinesis");
        skills.add("speed burst");
        skills.add("regeneration");
        skills.add("mind control");
        skills.add("energy blast");
        return skills;
    }

}