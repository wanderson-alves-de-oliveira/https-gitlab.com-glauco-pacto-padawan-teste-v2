package com.padwan.test.service;

import com.padwan.test.model.Jedi;
import com.padwan.test.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JediService {

    @Autowired
    private JediRepository jediRepository;

    public List<Object[]> getAllMestresAndApprentices() {
        return jediRepository.findAllMestresJedisAndApprentices();
    }

    public List<Jedi> getJediWithMidichloriansAbove9000() {
        return jediRepository.findJediWithMidichloriansAbove9000();
    }

    public List<Object[]> countJedisByCategory() {
        return jediRepository.countJedisByCategory();
    }
}

