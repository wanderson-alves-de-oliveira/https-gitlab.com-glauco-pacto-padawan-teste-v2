package com.padwan.test.service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.JediEntity;
import com.padwan.test.repository.JediRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JediService {

    private final JediRepository jediRepository;

    public JediService(JediRepository jediRepository) {
        this.jediRepository = jediRepository;
    }
   
    public void addJedi(JediDTO jediDTO) {
        JediEntity jediEntity = toEntity(jediDTO);
        jediRepository.save(jediEntity);
    }
   
    public List<JediEntity> getAllJedis() {
        return jediRepository.findAll();
    }

    public JediEntity getJediById(Long id) {
        return jediRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jedi not found with ID: " + id));
    }

    public void updateJedi(Long id, JediDTO jediDTO) {
        JediEntity existingJedi = jediRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jedi not found with ID: " + id));
        existingJedi.setName(jediDTO.getName());
        existingJedi.setStatus(jediDTO.getStatus());
        existingJedi.setMentor(jediDTO.getMentor());
        existingJedi.setMidichlorians(jediDTO.getMidichlorians());
        jediRepository.save(existingJedi);
    }
  
    public void deleteJedi(Long id) {
        JediEntity jedi = jediRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jedi not found with ID: " + id));
        jediRepository.delete(jedi);
    }
    
    private JediEntity toEntity(JediDTO jediDTO) {
        JediEntity entity = new JediEntity();
        entity.setName(jediDTO.getName());
        entity.setStatus(jediDTO.getStatus());
        entity.setMentor(jediDTO.getMentor());
        entity.setMidichlorians(jediDTO.getMidichlorians());
        return entity;
    }
    
   
    public List<Map<String, String>> getMastersAndApprentices() {
        List<Object[]> results = jediRepository.findMastersAndApprentices();
        List<Map<String, String>> response = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, String> map = new HashMap<>();
            map.put("mentor", (String) result[0]);
            map.put("apprentice", (String) result[1]);
            response.add(map);
        }
        return response;
    }
    
    public List<JediEntity> getJedisAboveMidichlorians() {
        return jediRepository.findJedisAboveMidichlorians();
    }

    
    public List<Map<String, Object>> getCountByCategory() {
        List<Object[]> results = jediRepository.countJedisByCategory();
        List<Map<String, Object>> response = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", result[0]);
            map.put("total", result[1]);
            response.add(map);
        }
        return response;
    }

}
