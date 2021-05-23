package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.service.KorisnickiServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnickiServis korisnickiServis;

    @GetMapping("/registracija-trenera")
    public String registracijaTrenera() {return "registracija_trenera.html";}



}
