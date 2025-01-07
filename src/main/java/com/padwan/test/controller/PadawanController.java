package com.padwan.test.controller;

import com.padwan.test.dto.Padawan;
import com.padwan.test.service.PadawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class PadawanController {

    private final PadawanService padawanService;

    @Autowired
    public PadawanController(PadawanService padawanService) {
        this.padawanService = padawanService;
    }
  
    @PostMapping("/criar")
    public ResponseEntity<?> createPadawan(@RequestBody Padawan padawanDTO) {
        try {
            Padawan createdPadawan = padawanService.process(padawanDTO);
            return new ResponseEntity<>(createdPadawan, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar o Padawan.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{name}/skills")
    public ResponseEntity<?> getSkills(@PathVariable("name") String name) {
        try {
            Padawan padawan = padawanService.getPadawanByName(name);
            if (padawan != null) {
                return new ResponseEntity<>(padawan.getSkills(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Padawan não encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao buscar as skills.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/mestres-aprendizes")
    public Map<String, List<Padawan>> listarMestresEAprendizes() {
        return padawanService.listarMestresEAprendizes();
    }

    @GetMapping("/jedis-midichlorians")
    public ResponseEntity<List<Padawan>> listarJedisComMidichloriansAcimaDe9000() {
        List<Padawan> jedisAcimaDe9000 = padawanService.listarJedisComMidichloriansAcimaDe9000();
        return ResponseEntity.ok(jedisAcimaDe9000);
    }

    @GetMapping("/quantidade-por-categoria")
    public ResponseEntity<List<Object[]>> listarQuantidadePorCategoria() {
        List<Object[]> quantidadePorCategoria = padawanService.listarQuantidadePorCategoria();
        return ResponseEntity.ok(quantidadePorCategoria);
    }
}
