package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.Trening;
import com.example.FitnessCetnar.entity.dto.TreningDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class TerminskaListaController {
    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTrenings(){
        List<Trening> treningList = this.treningService.findAll();

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Trening trening : treningList){
            TreningDTO treningDTO=new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getCena(),trening.getTrajanje(),trening.getTipTreninga());
            treningDTOS.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }*/
}
