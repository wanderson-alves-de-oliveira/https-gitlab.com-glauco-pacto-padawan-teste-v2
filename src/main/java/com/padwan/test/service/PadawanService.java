package com.padwan.test.service;

import com.padwan.test.dto.Padawan;
import com.padwan.test.dto.Skill;
import com.padwan.test.repository.PadawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PadawanService {

    private final PadawanRepository padawanRepository;
    private final SkillService skillService;

    @Autowired
    public PadawanService(PadawanRepository padawanRepository, SkillService skillService) {
        this.padawanRepository = padawanRepository;
        this.skillService = skillService;
    }

    private List<Skill> getSkillsByStatus(String status) {
        List<String> skillNames = skillService.getSkillNamesByStatus(status);
        return skillService.salvarOuAtualizarSkills(skillNames);
    }

    public Padawan process(Padawan padawanDTO) {
        if (!"Mestre Jedi".equalsIgnoreCase(padawanDTO.getStatus()) && padawanDTO.getMentor() == null) {
            throw new IllegalArgumentException("Padawans e Jedis precisam de um mentor.");
        }
        if (padawanDTO.getRanking() < 1 || padawanDTO.getRanking() > 100) {
            throw new IllegalArgumentException("O ranking deve estar entre 1 e 100.");
        }

        List<Skill> skills = getSkillsByStatus(padawanDTO.getStatus());

        Padawan padawan = new Padawan();
        padawan.setName(padawanDTO.getName());
        padawan.setStatus(padawanDTO.getStatus());
        padawan.setRanking(padawanDTO.getRanking());

        Integer midichlorians_maximo = 20000;
        Integer midichlorians_minimo = 200;
        Integer rank = padawanDTO.getRanking();
        Integer midichlorians = midichlorians_minimo + (midichlorians_maximo - midichlorians_minimo) * (101 - rank) / 100;        
        padawan.setMidichlorians(midichlorians);
        padawan.setMentor(padawanDTO.getMentor());
        padawan.setPlaneta(padawanDTO.getPlaneta());
        padawan.setClasse(padawanDTO.getClasse());
        padawan.setSkills(skills);
       
        return padawanRepository.save(padawan);

    }
    
    public Map<String, List<Padawan>> listarMestresEAprendizes() {
    
        List<Padawan> todosPadawans = padawanRepository.listarMestresEAprendizes();

        Map<String, List<Padawan>> mestresEAprendizes = new HashMap<>();

        for (Padawan padawan : todosPadawans) {
           
            if (padawan.getMentor() != null) {
                mestresEAprendizes
                    .computeIfAbsent(padawan.getMentor(), k -> new ArrayList<>())
                    .add(padawan);
            }
        }

        return mestresEAprendizes;
    }

    public List<Padawan> listarJedisComMidichloriansAcimaDe9000() {
        return padawanRepository.listarJedisComMidichloriansAcimaDe9000();
    }

    public List<Object[]> listarQuantidadePorCategoria() {
        return padawanRepository.contarJedisPorCategoria();
    }

    public Padawan getPadawanByName(String name) {
        return padawanRepository.findByName(name);
    }
}
