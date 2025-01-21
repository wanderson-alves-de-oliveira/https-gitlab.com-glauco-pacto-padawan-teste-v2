package com.padwan.test.service;

import com.padwan.test.dto.LadoLuzDTO;
import com.padwan.test.dto.MestreDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerarListaMestres {



    public static List<MestreDTO> listar(List<LadoLuzDTO> lista) {

        ArrayList<LadoLuzDTO> mestres = (ArrayList<LadoLuzDTO>) lista.stream()
                .filter(it -> "mestre".equals(it.getStatus()))
                .collect(Collectors.toList());

        List<MestreDTO> listaMestre = new ArrayList<>();

        for (LadoLuzDTO m : mestres) {

            MestreDTO mestre = new MestreDTO();
            mestre.setNome(m.getNome());

            List<LadoLuzDTO> discipulos = lista.stream()
                    .filter(it -> m.getNome().equals(it.getMestre()))
                    .collect(Collectors.toList());

            for (int j = 0; j < discipulos.size(); j++) {
                mestre.getDicipulos().add(discipulos.get(j).getNome());
            }

            listaMestre.add(mestre);
        }

        return listaMestre;
    }



}
