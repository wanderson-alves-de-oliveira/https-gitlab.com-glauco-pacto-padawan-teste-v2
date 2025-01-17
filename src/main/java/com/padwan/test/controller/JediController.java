package com.padwan.test.controller;

import com.padwan.test.model.Jedi;
import com.padwan.test.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jedi")
public class JediController {

    @Autowired
    private JediService jediService;

    @GetMapping("/mestres-e-aprendizes")
    public List<Object[]> getAllMestresAndApprentices() {
        return jediService.getAllMestresAndApprentices();
    }

    @GetMapping("/midichlorians-acima-9000")
    public List<Jedi> getJediWithMidichloriansAbove9000() {
        return jediService.getJediWithMidichloriansAbove9000();
    }

    @GetMapping("/contagem-por-categoria")
    public List<Object[]> countJedisByCategory() {
        return jediService.countJedisByCategory();
    }
}

