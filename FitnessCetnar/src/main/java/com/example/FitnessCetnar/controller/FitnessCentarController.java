package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.entity.dto.KorisnikDTO;
import com.example.FitnessCetnar.service.FitnescentarService;
import com.example.FitnessCetnar.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/fitnesscentar")
public class FitnessCentarController {

    private final FitnescentarService fitnescentarService;

    @Autowired
    public FitnessCentarController(FitnescentarService fitnescentarService) {
        this.fitnescentarService = fitnescentarService;
    }

    /*Dobavljanje trazenog korisnika*/
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnescentarDTO> getFitnesCentar(@PathVariable("id") Long id){
        FitnessCentar fitnessCentar = this.fitnescentarService.findOne(id);

        FitnescentarDTO fitnescentarDTO = new FitnescentarDTO();

        fitnescentarDTO.setId(fitnessCentar.getId());
        fitnescentarDTO.setNaziv(fitnessCentar.getNaziv());
        fitnescentarDTO.setAdresa(fitnessCentar.getAdresa());
        fitnescentarDTO.setEmail(fitnessCentar.getEmail());
        fitnescentarDTO.setBrTelefona(fitnessCentar.getBrTelefona());


        return new ResponseEntity<>(fitnescentarDTO,HttpStatus.OK);
    }
    /*Dobavljanje svih korisnika*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnescentarDTO>> getFitensCentars(){
        List<FitnessCentar> fitnessCentarList = this.fitnescentarService.findAll();

        List<FitnescentarDTO> fitnescentarDTOS = new ArrayList<>();

        for (FitnessCentar fitnessCentar : fitnessCentarList){
            FitnescentarDTO fitnescentarDTO=new FitnescentarDTO(fitnessCentar.getId(),fitnessCentar.getNaziv(),fitnessCentar.getAdresa(),fitnessCentar.getEmail(),
                    fitnessCentar.getBrTelefona());
            fitnescentarDTOS.add(fitnescentarDTO);
        }

        return new ResponseEntity<>(fitnescentarDTOS,HttpStatus.OK);
    }
    /*Kreiranje novog zaposlenog*/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register_korisnik(@RequestBody FitnessCentar fitnessCentar) {
        FitnessCentar fitnessCentar1;
        try {
            fitnessCentar1=fitnescentarService.save(fitnessCentar);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<FitnessCentar>(fitnessCentar1, HttpStatus.OK);
    }
    /*update postojeceg korisnika*/
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnescentarDTO> updateKorisnik(@PathVariable Long id,@RequestBody FitnescentarDTO fitnescentarDTO) throws Exception{
        FitnessCentar fitnessCentar = new FitnessCentar(fitnescentarDTO.getNaziv(),fitnescentarDTO.getAdresa(),fitnescentarDTO.getEmail(),
                fitnescentarDTO.getBrTelefona());
        fitnessCentar.setId(id);

        FitnessCentar updatedFC = fitnescentarService.update(fitnessCentar);

        FitnescentarDTO updatedFCDTO = new FitnescentarDTO(updatedFC.getId(),updatedFC.getNaziv(),
                updatedFC.getEmail(),updatedFC.getAdresa(),updatedFC.getBrTelefona());

        return new ResponseEntity<>(updatedFCDTO,HttpStatus.OK);
    }
    /*brisanje korisnika*/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFitnesCentar(@PathVariable Long id){
        this.fitnescentarService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
