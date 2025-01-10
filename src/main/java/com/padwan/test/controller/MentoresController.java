package com.padwan.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.dto.MentorDTO;
import com.padwan.test.entity.Mentor;
import com.padwan.test.service.MentoresService;

@RestController
@RequestMapping("/mentores")
public class MentoresController {
    
    @Autowired
    MentoresService mentoresService;

    public void setMentoresService(MentoresService mentoresService) {
        this.mentoresService = mentoresService;
    }
    //Listar todos os mestres Jedis e seus aprendizes;
    @ResponseBody
    @RequestMapping(value = "/listarMentores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> mestres() {
        try {
            List<Mentor> mentores = mentoresService.getMentoresComAprendizes();


            return new ResponseEntity<>(mentores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Criar Mentor
    @PostMapping("/criarMentor")
    public ResponseEntity<Object> CriarMentor(@RequestBody MentorDTO mentorDTO) {
        System.out.println(mentorDTO.getNome());
        try {
            mentoresService.CriarMentor(mentorDTO);
            return new ResponseEntity("Mentor criado com sucesso!", HttpStatus.CREATED); // HTTP 201
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Erro ao processar o Mentor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
