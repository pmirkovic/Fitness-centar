package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.TerminskaLista;
import com.example.FitnessCetnar.entity.Trening;
import com.example.FitnessCetnar.entity.dto.TreningDTO;
import com.example.FitnessCetnar.service.TerminskaListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/terminskalista/")
public class TerminskaListaController {

    @Autowired
    TerminskaListaService terminskaListaService;

    @GetMapping("/{id}")
    public TerminskaLista getOne(@PathVariable Long id){
        return terminskaListaService.getOne(id);
    }

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
