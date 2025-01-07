package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LucasCarvalhoService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Javascript");
        skills.add("Typescript");
        skills.add("C++");
        skills.add("Angular");
        skills.add("React");
        skills.add("Scrum");
        skills.add("Análise de Sistemas");
        skills.add("Banco de dados relacionais (PostgreSQL, SQL Server)");
        skills.add("Tecnico em Manutençao e suporte em Informatica");

        return skills;
    }

}
