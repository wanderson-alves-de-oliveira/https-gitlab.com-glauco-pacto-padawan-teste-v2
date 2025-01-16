package com.padwan.test.controller;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.model.Jedi;
import com.padwan.test.model.enums.StatusJediEnum;
import com.padwan.test.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/jedi")
public class JediController {

    @Autowired
    private JediService jediService;

    @Autowired
    public JediController(JediService jediService) {
        this.jediService = jediService;
    }

    @PostMapping(path = "/createJedi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Jedi> createJedi(@Validated @RequestBody JediDTO jediDTO, UriComponentsBuilder uriBuilder) {

        try {
            Jedi jedi = jediService.createJedi(jediDTO);
            URI uri = uriBuilder.path("/jedi/{id}").buildAndExpand(jedi.getId()).toUri();
            return ResponseEntity.created(uri).body(jedi);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(path = "/listJedi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Object[]>> listJedi() {
        try{
        List<Object[]> jedis = jediService.listJedi();
        return new ResponseEntity<>(jedis, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/jedisPower")
    public ResponseEntity<List<Object[]>> listJedisByPower() {
        try{
        List<Object[]> jedis = jediService.listJedisByPower();
        return new ResponseEntity<>(jedis, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/jedisByStatus")
    public ResponseEntity<List<Object[]>>countJedisByStatus() {
        try {
        List<Object[]> statusCount = jediService.countJedisByStatus();
        return new ResponseEntity<>(statusCount, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}