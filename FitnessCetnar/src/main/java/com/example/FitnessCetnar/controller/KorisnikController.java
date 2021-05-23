package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.service.FitnescentarService;
import com.example.FitnessCetnar.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private FitnescentarService fitnescentarService;

    @GetMapping("/registracija")
    public String registracija() {return "registracija.html";}

    @PostMapping("/registracija-korisnik")
    public ResponseEntity<?> registracija_korisnik(@RequestBody Korisnik korisnik){
        Korisnik korisnik1;
        try{
            korisnik1 = korisnikService.save(korisnik);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Korisnik>(korisnik1,HttpStatus.OK);
    }

    @PostMapping("/add_fitnescentar")
    public ResponseEntity<?> add_fitnescentar(@RequestBody FitnescentarDTO fitnescentarDTO){
        try{
            korisnikService.addFitnrescentar(fitnescentarDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/edit_fitnescentar")
    public ResponseEntity<?> edit_fitnescentar(@RequestBody FitnessCentar fitnessCentar){
        try {
            this.korisnikService.editFitnescentar(fitnessCentar);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_fitnescentar/{id}")
    public ResponseEntity<?> delete_fitnescentar(@PathVariable(name = "id") Long id){
        try{
            this.fitnescentarService.deleteFitnescentar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
