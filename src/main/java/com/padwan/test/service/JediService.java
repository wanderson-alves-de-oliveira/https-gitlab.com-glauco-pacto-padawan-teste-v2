package com.padwan.test.service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.model.Jedi;
import com.padwan.test.model.enums.StatusJediEnum;
import com.padwan.test.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JediService {

    @Autowired
    private JediRepository jediRepository;


    @Autowired
    public JediService(JediRepository jediRepository) {
        this.jediRepository = jediRepository;
    }

    public Jedi createJedi(JediDTO jediDTO) {
        return jediRepository.save(new Jedi(jediDTO.getName(), StatusJediEnum.toEnum(jediDTO.getStatus()), jediDTO.getMentor(), jediDTO.getMidichlorians()));
    }

    public List<Object[]> listJedi() {
        List<Object[]> converter = jediRepository.listJedi();
        return converter.stream()
                .map(x -> new Object[]{
                        x[0],
                        StatusJediEnum.toEnum((Integer) x[1]).getDescription(),
                        x[2],
                        x[3]
                })
                .collect(Collectors.toList());
    }

    public List<Object[]> listJedisByPower() {
        List<Object[]> converter = jediRepository.listJediByPower();
        return converter.stream()
                .map(x -> new Object[]{
                        x[0],
                        StatusJediEnum.toEnum((Integer) x[1]).getDescription(),
                        x[2],
                        x[3]
                })
                .collect(Collectors.toList());
    }

    public List<Object[]> countJedisByStatus() {
        List<Object[]> converter = jediRepository.countJediByStatus();
        return converter.stream()
                .map(x -> new Object[]{
                        StatusJediEnum.toEnum((Integer) x[0]).getDescription(),
                        x[1]
                })
                .collect(Collectors.toList());
    }
}
