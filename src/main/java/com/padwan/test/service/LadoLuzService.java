package com.padwan.test.service;

import com.padwan.test.dto.LadoLuzDTO;
import com.padwan.test.repository.LadoLuzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LadoLuzService {

    @Autowired
    private LadoLuzRepository repository;

    public LadoLuzDTO process(LadoLuzDTO luz, boolean update) {
        LadoLuzDTO ladoLuzDTO = new LadoLuzDTO();
        ladoLuzDTO.setNome(luz.getNome().split(" ")[0]);
        ladoLuzDTO.setStatus(luz.getStatus().split(" ")[0]);
        ladoLuzDTO.setMestre(luz.getMestre().split(" ")[0]);
        ladoLuzDTO.setMidichlorians(luz.getMidichlorians());
        if (update)
            ladoLuzDTO.setId(luz.getId());

        return ladoLuzDTO;
    }

    public boolean inserir(LadoLuzDTO luz) {
        repository.save(process(luz, false));

        return true;
    }

    public LadoLuzDTO update(LadoLuzDTO luz, Integer id) {
        LadoLuzDTO update = process(luz, true);
        repository.save(update);

        return update;
    }


    public void deletar(Integer id) {
        repository.deleteById(id);

    }


    public Optional<LadoLuzDTO> pegar(Integer id) {
        Optional<LadoLuzDTO> luz = repository.findById(id);
        return luz;
    }


    public List<LadoLuzDTO> lista() {
        List<LadoLuzDTO> luz = repository.findAll();
        return luz;
    }


    public List<LadoLuzDTO> listaMestres() {
        List<LadoLuzDTO> luz = repository.findAll();
        return luz;
    }

    public List<LadoLuzDTO> listarAcimaDe(Integer midichlorians) {
        List<LadoLuzDTO> luz = repository.findByMidichlorians(midichlorians);
        return luz;
    }

    public List<LadoLuzDTO> listarcategoria(String status) {
        List<LadoLuzDTO> luz = repository.findByStatus(status);
        return luz;
    }



}
