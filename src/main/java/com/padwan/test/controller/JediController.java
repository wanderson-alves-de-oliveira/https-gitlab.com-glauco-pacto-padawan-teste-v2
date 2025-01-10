package com.padwan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.padwan.test.dto.JediDTO;
import com.padwan.test.interfaces.JediServiceInterface;

@RestController
@RequestMapping("/jedi")
public class JediController {

	private JediServiceInterface jediService;
	
	@Autowired
	public JediController(JediServiceInterface jediService) {
		this.jediService = jediService;
	}

	@ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createJedi(@RequestBody JediDTO json) {
        try {
            return new ResponseEntity(jediService.createJedi(json), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("erro ao criar Jedi", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	
	@ResponseBody
    @RequestMapping(value = "/list-jedi-masters-and-apprentices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listJediMastersAndApprentices() {
        try {
            return new ResponseEntity(jediService.listJediMastersAndApprentices(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@ResponseBody
    @RequestMapping(value = "/list-jedis-midichlorians-over-9000", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listJedisMidichloriansOver9000() {
        try {
            return new ResponseEntity(jediService.listJedisMidichloriansOver9000(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@ResponseBody
    @RequestMapping(value = "/list-jedi-status-count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listJediStatusCount() {
        try {
            return new ResponseEntity(jediService.listJediStatusCount(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
