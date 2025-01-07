package com.padwan.test.service;

import com.padwan.test.dto.JediDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JediService {

    @PersistenceContext
    private EntityManager entityManager;

    private List<JediDTO> jedis = new ArrayList<>();

    public JediDTO createJedi(JediDTO jediDTO) {
        // Define uma quantidade fictícia de midichlorians para o Jedi criado
        jediDTO.setMidichlorians(generateMidichlorians(jediDTO));
        jedis.add(jediDTO);
        return jediDTO;
    }

    public List<JediDTO> getAllJedis() {
        return jedis;
    }

    private int generateMidichlorians(JediDTO jediDTO) {
        int baseValue = 1000;
        if ("Padawan".equalsIgnoreCase(jediDTO.getStatus())) {
            baseValue += 500;
        } else if ("Knight".equalsIgnoreCase(jediDTO.getStatus())) {
            baseValue += 1000;
        } else if ("Master".equalsIgnoreCase(jediDTO.getStatus())) {
            baseValue += 2000;
        }
        // Adicionando o fator de conexão com a Força (quanto mais alto, mais midichlorians)
        baseValue += jediDTO.getConexaoComAForca() != null ? jediDTO.getConexaoComAForca() * 1000 : 0;
        // Fator adicional baseado no nome do Jedi
        return baseValue + (jediDTO.getNome().length() * 10);
    }

    public List<Map<String, String>> getMastersAndApprentices() {
        String sql = "SELECT master.nome AS mestre, apprentice.nome AS aprendiz " +
                     "FROM jedis AS master " +
                     "JOIN jedis AS apprentice ON master.id = apprentice.mentor_id " +
                     "WHERE master.status = 'Master'";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        List<Map<String, String>> response = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, String> map = new HashMap<>();
            map.put("mestre", (String) result[0]);
            map.put("aprendiz", (String) result[1]);
            response.add(map);
        }
        return response;
    }

    public List<JediDTO> getJedisAbove9000() {
        String sql = "SELECT j.nome, j.status, m.nome AS mentor_nome, j.midichlorians, j.conexao_com_a_forca " +
                     "FROM jedis j " +
                     "LEFT JOIN jedis m ON j.mentor_id = m.id " +
                     "WHERE j.midichlorians > 9000";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        List<JediDTO> response = new ArrayList<>();
        for (Object[] result : results) {
            JediDTO jedi = new JediDTO();
            jedi.setNome((String) result[0]);
            jedi.setStatus((String) result[1]);
            jedi.setMentor((String) result[2]);
            jedi.setMidichlorians((Integer) result[3]);
            jedi.setConexaoComAForca((Double) result[4]);
            response.add(jedi);
        }
        return response;
    }

    public List<Map<String, Object>> getCountByCategory() {
        String sql = "SELECT status, COUNT(*) AS quantidade FROM jedis GROUP BY status";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        List<Map<String, Object>> response = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", (String) result[0]);
            map.put("quantidade", ((Number) result[1]).intValue());
            response.add(map);
        }
        return response;
    }
}
