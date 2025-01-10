package com.padwan.test.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.dto.GenericoDTO;
import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.Mentor;
import com.padwan.test.service.JedisService;

@RestController
@RequestMapping("/jedis")
public class JedisController {

    @Autowired
    JedisService jedisService;

    public void setJedisService(JedisService jedisService) {
        this.jedisService = jedisService;
    }



    //Listar todos Jedis cujo midichlorians sejam acima de 9000;
    @ResponseBody
    @RequestMapping(value = "/jedisFortes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> jedisFortes() {
        try {
            List<Jedi> jedisFortes = jedisService.getJedisFortes();

            return new ResponseEntity<>(jedisFortes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Listar por categoria, quantos são os Jedis;
    @ResponseBody
    @RequestMapping(value = "/jedisCategorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> JedisStatus() {
        try {

            int Padawan = jedisService.getQuantidadePorStatus("padawan");
            int Jedi = jedisService.getQuantidadePorStatus("jedi");
            int Mestre = jedisService.getQuantidadePorStatus("mestre jedi");

            String response = String.format("Quantidade de Padawan: %d\nQuantidade de Jedi: %d\nQuantidade de Mestre Jedi: %d", Padawan, Jedi, Mestre);

            return new ResponseEntity(response, HttpStatus.OK); 

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Criar Jedi
    @PostMapping("/criarJedi")
    public ResponseEntity<Object> CriarJedi(@RequestBody JediDTO jediDTO) {
        try {
            jedisService.CriarJedi(jediDTO);
            
            return new ResponseEntity("Jedi criado com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Erro ao processar o Jedi", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
