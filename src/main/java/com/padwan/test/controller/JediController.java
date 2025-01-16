package com.padwan.test.controller;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.entity.JediEntity;
import com.padwan.test.service.JediService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jedi")
public class JediController {

    private final JediService jediService;

    public JediController(JediService jediService) {
        this.jediService = jediService;
    }
 
    @PostMapping("/add")
    public ResponseEntity<Object> addJedi(@Valid @RequestBody JediDTO jediDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> 
                errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            jediService.addJedi(jediDTO);
            return ResponseEntity.ok("Jedi added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> listJedis() {
        try {
            return ResponseEntity.ok(jediService.getAllJedis());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getJediById(@PathVariable Long id) {
        try {
            JediEntity jedi = jediService.getJediById(id);
            return ResponseEntity.ok(jedi);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateJedi(
        @PathVariable Long id, 
        @Valid @RequestBody JediDTO jediDTO, 
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> 
                errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            jediService.updateJedi(id, jediDTO);
            return ResponseEntity.ok("Jedi updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteJedi(@PathVariable Long id) {
        try {
            jediService.deleteJedi(id);
            return ResponseEntity.ok("Jedi deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    @GetMapping("/masters-and-apprentices")
    public ResponseEntity<Object> getMastersAndApprentices() {
        try {
            return ResponseEntity.ok(jediService.getMastersAndApprentices());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
  
    @GetMapping("/above-midichlorians")
    public ResponseEntity<Object> getJedisAboveMidichlorians() {
        try {
            List<JediEntity> result = jediService.getJedisAboveMidichlorians();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/count-by-category")
    public ResponseEntity<Object> getCountByCategory() {
        try {
            return ResponseEntity.ok(jediService.getCountByCategory());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
