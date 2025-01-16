package com.padwan.test.service;

import com.padwan.test.model.Jedi;
import com.padwan.test.model.enums.StatusJediEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SilvioService {

    public List<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add("resolve problems");
        skills.add("refactor code");
        skills.add("maintain code");
        skills.add("create queries");
        skills.add("eliminate bugs");
        return skills;
    }

}
