package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Sala;
import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.entity.dto.SalaDTO;
import com.example.FitnessCetnar.entity.dto.TrenerDTO;
import com.example.FitnessCetnar.service.FitnescentarService;
import com.example.FitnessCetnar.service.KorisnikService;
import com.example.FitnessCetnar.service.SalaService;
import org.aspectj.weaver.patterns.ExactAnnotationTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private FitnescentarService fitnescentarService;
    @Autowired
    private SalaService salaService;

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
    /*FITNESCENTART DODAVANJE IZMENA BRISANJE*/
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
    /*----------*/
    /*SALA DODAVANJE IZMNA BRISANJE*/
    @DeleteMapping("/delete_sala/{fitness_centar_id}/sala/{sala_id}")
    public ResponseEntity<?> delete_sala(@PathVariable(name = "fitness_centar_id") Long fitness_centar_id,@PathVariable(name = "sala_id") Long sala_id){
        try{
            if(this.salaService.deleteById(fitness_centar_id,sala_id))
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add_sala")
    public ResponseEntity<?> add_sala(@RequestBody SalaDTO salaDTO){
        try{
            korisnikService.addSala(salaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PutMapping("/edit_sala")
    public ResponseEntity<?> edit_sala(@RequestBody Sala sala){
        try {
            this.korisnikService.editSala(sala);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    /*----------*/
    /**/
    @PostMapping("/registracija-trener")
    public ResponseEntity<?> create_trenera(@RequestBody TrenerDTO trenerDTO){
        try {
            this.korisnikService.saveTrener(trenerDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/registracija_trenera")
    public String registracija_trenera(@PathVariable(name = "id") Long id, Model model){
        List<FitnessCentar> fitnessCentarList = this.fitnescentarService.findAll();
        Korisnik korisnik=this.korisnikService.findOne(id);
        model.addAttribute("fitnes", fitnessCentarList);
        model.addAttribute("korisnik",korisnik);
        return "registracija_trenera.html";
    }

    @DeleteMapping("/remove_trener/{id}")
    public ResponseEntity<?> remove_trener(@PathVariable(name = "id")Long id){
        try{
            this.korisnikService.deleteKorisnik(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    /*----------*/

}
