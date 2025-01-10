package com.padwan.test.service;

import com.padwan.test.dto.Skill;
import com.padwan.test.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<String> getSkillNamesByStatus(String status) {
        switch (status.toLowerCase()) {
            case "padawan":
                return List.of("técnicas básicas de sabre de luz", "percepção básica da força", "habilidade de combate corpo a corpo", "treinamento inicial em uso da força");
            case "jedi":
                return List.of("combate com sabre de luz", "manipulação avançada da força", "salto com a força", "defesa mental", "cura com a força", "percepção aprimorada da força");
            case "mestre jedi":
                return List.of("controle mestre da força", "visão da força", "domínio do sabre de luz", "telepatia", "transporte com a força", "influência mental", "controle de sentimentos");
            default:
                throw new IllegalArgumentException("Status inválido: " + status);
        }
    }

    public List<Skill> salvarOuAtualizarSkills(List<String> nomesDasSkills) {
        return nomesDasSkills.stream()
                .map(this::encontrarOuCriarSkill)
                .collect(Collectors.toList());
    }

    private Skill encontrarOuCriarSkill(String nomeDaSkill) {
        Skill skillExistente = skillRepository.findByName(nomeDaSkill);
        if (skillExistente != null) {
            return skillExistente; 
        }

        Skill novaSkill = new Skill();
        novaSkill.setName(nomeDaSkill);

        return skillRepository.save(novaSkill);
    }
}
