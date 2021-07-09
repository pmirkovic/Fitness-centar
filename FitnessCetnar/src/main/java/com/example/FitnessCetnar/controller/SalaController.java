package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Sala;
import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.entity.dto.SalaDTO;
import com.example.FitnessCetnar.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sala")

public class SalaController {

    private final SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    /*Dobavljanje trazenog korisnika*/
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> getSala(@PathVariable("id") Long id){
        Sala sala = this.salaService.findOne(id);

        SalaDTO salaDTO = new SalaDTO();

        salaDTO.setId(sala.getId());
        salaDTO.setKapacitet(sala.getKapacitet());
        salaDTO.setOznakaSale(sala.getOznakaSale());


        return new ResponseEntity<>(salaDTO, HttpStatus.OK);
    }
    /*Dobavljanje svih korisnika*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSalas(){
        List<Sala> salaList = this.salaService.findAll();

        List<SalaDTO> salaDTOS = new ArrayList<>();

        for (Sala sala : salaList){
            SalaDTO salaDTO=new SalaDTO(sala.getId(),sala.getKapacitet(),sala.getOznakaSale());
            salaDTOS.add(salaDTO);
        }

        return new ResponseEntity<>(salaDTOS,HttpStatus.OK);
    }
    /*Kreiranje novog zaposlenog*/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register_sala(@RequestBody Sala sala) {
        Sala sala1;
        try {
            sala1=salaService.save(sala);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Sala>(sala1, HttpStatus.OK);
    }
    /*update postojeceg korisnika*/
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> updateSala(@PathVariable Long id,@RequestBody SalaDTO salaDTO) throws Exception{
        Sala sala = new Sala(salaDTO.getKapacitet(),salaDTO.getOznakaSale());
        sala.setId(id);

        Sala updatedS = salaService.update(sala);

        SalaDTO updatedSDTO = new SalaDTO(updatedS.getId(),updatedS.getKapacitet(),
                updatedS.getOznakaSale());

        return new ResponseEntity<>(updatedSDTO,HttpStatus.OK);
    }
    /*brisanje korisnika*/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id){
        this.salaService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/edit_sala/{id}")
    public ResponseEntity<?> edit_sala(@RequestBody Sala sala){
        try{
            this.salaService.editSala(sala);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
