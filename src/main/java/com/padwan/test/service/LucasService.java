package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LucasService {

    public List<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add("Devastating punch");
        skills.add("Spinning kick");
        skills.add("Keyboard throw");
        skills.add("Debugging with eyes closed");        
        skills.add("Mastery of CTRL+C and CTRL+V");
        return skills;
    }
}
