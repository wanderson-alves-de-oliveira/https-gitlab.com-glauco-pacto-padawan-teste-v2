package com.padwan.test.controller;

import com.padwan.test.service.LucasCarvalhoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lucascarvalho")
public class LucasCarvalhoController {

    private LucasCarvalhoService lucascarvalhoService;

    @Autowired
    public LucasCarvalhoController(LucasCarvalhoService lucascarvalhoService){
        this.lucascarvalhoService = lucascarvalhoService;
    }

    @ResponseBody
    @RequestMapping(value = "/skills", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> skills() {
        try {
            JSONObject json = new JSONObject();
            json.put("Lucas Carvalho Costa", lucascarvalhoService.skills());
            return new ResponseEntity(json.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
