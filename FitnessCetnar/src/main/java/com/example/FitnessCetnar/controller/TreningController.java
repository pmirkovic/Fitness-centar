package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.*;
import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.entity.dto.KorisnikDTO;
import com.example.FitnessCetnar.entity.dto.TerminskaListaDTO;
import com.example.FitnessCetnar.entity.dto.TreningDTO;
import com.example.FitnessCetnar.service.FitnescentarService;
import com.example.FitnessCetnar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/trening")
public class TreningController {

    private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService) {
        this.treningService = treningService;
    }


    /*Dobavljanje trazenog korisnika*/
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> getTrening(@PathVariable("id") Long id){
        Trening trening = this.treningService.findOne(id);

        TreningDTO treningDTO = new TreningDTO();

        treningDTO.setId(trening.getId());
        treningDTO.setNaziv(trening.getNaziv());
        treningDTO.setTrajanje(trening.getTrajanje());
        treningDTO.setCena(trening.getCena());
        treningDTO.setOpis(trening.getOpis());
        treningDTO.setTipTreninga(trening.getTipTreninga());


        return new ResponseEntity<>(treningDTO,HttpStatus.OK);

    }
    /*Dobavljanje svih korisnika*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTrenings(){
        List<Trening> treningList = this.treningService.findAll();

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Trening trening : treningList){
            TreningDTO treningDTO=new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getCena(),trening.getTrajanje(),trening.getTipTreninga());
            treningDTOS.add(treningDTO);
            
        }

        return new ResponseEntity<>(treningDTOS,HttpStatus.OK);
    }

    /*Kreiranje novog zaposlenog*/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> createTrening(@RequestBody TreningDTO treningDTO) throws Exception{
        Trening trening = new Trening(treningDTO.getNaziv(),treningDTO.getOpis(),treningDTO.getCena(),
                treningDTO.getCena(),treningDTO.getTipTreninga());

        Trening newTrening = treningService.create(trening);

        TreningDTO newTreningDTO = new TreningDTO(newTrening.getId(),newTrening.getNaziv(),newTrening.getOpis(),newTrening.getCena(),
                newTrening.getTrajanje(),newTrening.getTipTreninga());

        return new ResponseEntity<>(newTreningDTO,HttpStatus.CREATED);
    }
    /*update postojeceg korisnika*/
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> updateTrening(@PathVariable Long id,@RequestBody TreningDTO treningDTO) throws Exception{
        Trening trening = new Trening(treningDTO.getNaziv(),treningDTO.getOpis(),treningDTO.getCena(),
                treningDTO.getTrajanje(),treningDTO.getTipTreninga());
        trening.setId(id);

        Trening updatedT = treningService.update(trening);

        TreningDTO updatedTDTO = new TreningDTO(updatedT.getId(),updatedT.getNaziv(),
                updatedT.getOpis(),updatedT.getCena(),updatedT.getTrajanje(),updatedT.getTipTreninga());

        return new ResponseEntity<>(updatedTDTO,HttpStatus.OK);
    }
    /*brisanje korisnika*/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFitnesCentar(@PathVariable Long id){
        this.treningService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}


