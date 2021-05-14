package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.Korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/api/employees" ,method={RequestMethod.GET,RequestMethod.POST})
public class EmployeeController {

    String getHome(){
        return "index";
    }

    String getOdobrenje(){
        return "odobrenje";
    }

}
