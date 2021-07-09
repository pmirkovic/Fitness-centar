package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Prijava;
import com.example.FitnessCetnar.service.PrijavaService;
import com.example.FitnessCetnar.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/prijava")
public class PrijavaController {

    @Autowired
    PrijavaService prijavaService;


    @PostMapping("")
    public ResponseEntity<Prijava> postPrijava(@RequestBody Prijava prijava){

        return new ResponseEntity<>(prijavaService.save(prijava), HttpStatus.OK);
    }

    @GetMapping("/korisnik/{id}")
    public List<Prijava> getPrijave(@PathVariable Long id){
        return prijavaService.findByKorisnik_Id(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePrijava(@PathVariable Long id){
        prijavaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}/odradjen")
    public ResponseEntity<HttpStatus> postaviOdradjenPrijava(@PathVariable Long id){
        // izvuci prijavu sa tim id-em
        Prijava prijava = this.prijavaService.findOne(id);
        // postaviti status da je odradjen true
        prijava.setOdradjen(true);
        // i sacuvati u bazu podataka
        prijavaService.save(prijava);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
