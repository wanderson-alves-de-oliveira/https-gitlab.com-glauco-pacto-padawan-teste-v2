package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WandersonService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("força de levantar cedo");
        skills.add("força de estudar mais kotlin");
        skills.add("força de criar um app novo");
        return skills;
    }

}
