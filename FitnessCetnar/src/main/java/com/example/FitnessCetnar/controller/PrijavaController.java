package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.Prijava;
import com.example.FitnessCetnar.service.PrijavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prijava")
public class PrijavaController {

    @Autowired
    PrijavaService prijavaService;

    @PostMapping("/")
    public ResponseEntity<HttpStatus> postPrijava(@RequestBody Prijava prijava){
        prijavaService.save(prijava);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
