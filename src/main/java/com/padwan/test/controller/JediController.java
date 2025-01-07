package com.padwan.test.controller;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jedis")
public class JediController {

    @Autowired
    private JediService jediService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JediDTO> createJedi(@RequestBody JediDTO jediDTO) {
        JediDTO createdJedi = jediService.createJedi(jediDTO);
        return new ResponseEntity<>(createdJedi, HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JediDTO>> getAllJedis() {
        List<JediDTO> jedis = jediService.getAllJedis();
        return new ResponseEntity<>(jedis, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/masters-and-apprentices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, String>>> getMastersAndApprentices() {
        List<Map<String, String>> result = jediService.getMastersAndApprentices();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/above-9000", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JediDTO>> getJedisAbove9000() {
        List<JediDTO> result = jediService.getJedisAbove9000();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/count-by-category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> getCountByCategory() {
        List<Map<String, Object>> result = jediService.getCountByCategory();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
