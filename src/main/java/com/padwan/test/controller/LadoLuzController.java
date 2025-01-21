package com.padwan.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.padwan.test.dto.LadoLuzDTO;
import com.padwan.test.dto.MestreDTO;
import com.padwan.test.service.GerarListaMestres;
import com.padwan.test.service.LadoLuzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/luz")
public class LadoLuzController {


    private LadoLuzService ladoLuzService;



    @Autowired
    public LadoLuzController(LadoLuzService ladoLuzService) {
        this.ladoLuzService = ladoLuzService;
    }



    private GerarListaMestres gerarListaMestre= new GerarListaMestres();

    @ResponseBody
    @RequestMapping(value = "/inserir",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity inserir(@RequestBody LadoLuzDTO json) {
        try {

            ladoLuzService.inserir(json);

            return new ResponseEntity("salvo com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("erro ao salvar luz", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable("id") Integer id,@RequestBody LadoLuzDTO json) {
        try {

            LadoLuzDTO update = ladoLuzService.update(json,id);
            return new ResponseEntity( update, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("erro ao atualizar  luz", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/deletar/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletar(@PathVariable("id") Integer id) {
        try {
            ladoLuzService.deletar(id);
            return new ResponseEntity( "Deletado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("erro ao deletar id = "+id, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @ResponseBody
    @RequestMapping(value = "/pegar/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity pegar(@PathVariable("id") Integer id) {
        try {

            return new ResponseEntity( ladoLuzService.pegar(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("erro ao procurar luz", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/lista",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity lista() {
        try {

            return new ResponseEntity( ladoLuzService.lista(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("erro ao procurar luz", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @ResponseBody
    @RequestMapping(value = "/listaMestres",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listaMestres() {
        try {

           List<LadoLuzDTO> listaDTO = ladoLuzService.listaMestres();
           List<MestreDTO> lista = gerarListaMestre.listar(listaDTO);
            ObjectMapper objectMapper = new ObjectMapper();
           String json = objectMapper.writeValueAsString(lista);
            return new ResponseEntity( json, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("erro ao procurar luz", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @ResponseBody
    @RequestMapping(value = "/nivel/{midichlorians}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listarAcimaDe(@PathVariable("midichlorians") Integer midichlorians) {
        try {

            return new ResponseEntity( ladoLuzService.listarAcimaDe(midichlorians), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("erro ao procurar luz", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @ResponseBody
    @RequestMapping(value = "/categoria/{status}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listarcategoria(@PathVariable("status") String status) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<LadoLuzDTO> lista  =  ladoLuzService.listarcategoria(status);
            String qtd = "quantidade : "+lista.size();
            String listaS = objectMapper.writeValueAsString(lista);
            StringBuilder json = new StringBuilder();
            json.append("{").append(qtd).append(",").append(listaS).append("]");
            return new ResponseEntity(json.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("erro ao procurar luz", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
