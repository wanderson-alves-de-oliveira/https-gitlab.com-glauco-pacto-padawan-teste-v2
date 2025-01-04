package com.padwan.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.stereotype.Service;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.Mentor;
import com.padwan.test.repositories.JedisRepository;
import com.padwan.test.repositories.MentorRepository;

@Service
public class JedisService {

    @Autowired
    JedisRepository jedisRepository;
    
    @Autowired
    MentorRepository mentorRepository;

    public void setJedisRepository(JedisRepository jedisRepository) {
        this.jedisRepository = jedisRepository;
    }
    // Poder ser feito a função pelo repository tambem dessa forma que gasta menos da memória do servidor:
    // "SELECT * FROM jedi WHERE midichlorians > 9000"
    public List<Jedi> getJedisFortes() {
        List<Jedi> jedis = jedisRepository.findAllJedis();
        List<Jedi> jedisFortes = new ArrayList<>();

        for (Jedi jedi : jedis) {
            if (jedi.getMidichlorians() > 9000) {
                jedisFortes.add(jedi);
            }
        }

        return jedisFortes;
    }

    public int getQuantidadePorStatus(String status) {
        List<Jedi> jedis = jedisRepository.findAllJedis();
        int count = 0;
    
        for (Jedi jedi : jedis) {
            if (jedi.getStatus().equalsIgnoreCase(status)) {
                count++;
            }
        }
        return count;
    }

    
    public void CriarJedi(JediDTO jediDTO) {
        Jedi jedi = new Jedi();
        Mentor mentorExistente = mentorRepository.findByNomeMentor(jediDTO.getMentor().getNome());
        
        jediDTO.setMentor(mentorExistente);
        
        jedi.setNome(jediDTO.getNome());
        jedi.setStatus(jediDTO.getStatus());
        jedi.setMidichlorians(jediDTO.getMidichlorians());
        jedi.setMentor(mentorExistente);

        jedisRepository.save(jedi);

    }
}
