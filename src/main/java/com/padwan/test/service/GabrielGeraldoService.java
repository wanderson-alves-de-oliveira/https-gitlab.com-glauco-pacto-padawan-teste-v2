package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GabrielGeraldoService {

	public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("Calm");
        skills.add("persistent");
        skills.add("committed");
        skills.add("responsible");
        return skills;
    }
	
}
