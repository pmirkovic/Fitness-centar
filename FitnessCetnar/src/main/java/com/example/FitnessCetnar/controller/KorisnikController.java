package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.*;
import com.example.FitnessCetnar.entity.dto.*;
import com.example.FitnessCetnar.service.FitnescentarService;
import com.example.FitnessCetnar.service.KorisnikService;
import com.example.FitnessCetnar.service.SalaService;
import com.example.FitnessCetnar.service.TreningService;
import org.aspectj.weaver.patterns.ExactAnnotationTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {

    private final KorisnikService korisnikService;
    private final TreningService treningService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService,TreningService treningService) {
        this.korisnikService = korisnikService;
        this.treningService = treningService;
    }

    /*Dobavljanje trazenog korisnika*/
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable("id") Long id){
        Korisnik korisnik = this.korisnikService.findOne(id);

        KorisnikDTO korisnikDTO = new KorisnikDTO();

        korisnikDTO.setId(korisnik.getId());
        korisnikDTO.setIme(korisnik.getIme());
        korisnikDTO.setPrezime(korisnik.getPrezime());
        korisnikDTO.setPosition(korisnik.getPosition());
        korisnikDTO.setEmail(korisnik.getEmail());
        korisnikDTO.setAktivan(korisnik.getAktivan());


        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }
    /*Dobavljanje svih korisnika*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getKorisniks(){
        List<Korisnik> korisnikList = this.korisnikService.findAll();

        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

        for (Korisnik korisnik : korisnikList){
            KorisnikDTO korisnikDTO=new KorisnikDTO(korisnik.getId(),korisnik.getIme(),korisnik.getPrezime(),korisnik.getPosition(),korisnik.getUsername(),
                    korisnik.getEmail(), korisnik.getTelefon(),korisnik.getDatum(),korisnik.getAktivan(), korisnik.getPassword());
            korisnikDTOS.add(korisnikDTO);
        }

        return new ResponseEntity<>(korisnikDTOS,HttpStatus.OK);
    }
    /*Kreiranje novog zaposlenog*/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register_korisnik(@RequestBody Korisnik korisnik) {
        Korisnik korisnik1;
        try {
            korisnik1=korisnikService.save(korisnik);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Korisnik>(korisnik1, HttpStatus.OK);
    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> login(@RequestBody KorisnikDTO korisnikDTO){
        System.out.println("proba");

        Korisnik korisnik;
        try {
            korisnik=this.korisnikService.checkEmail(korisnikDTO);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        if(korisnik==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!(this.korisnikService.login(korisnikDTO, korisnik))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        KorisnikDTO retDTO = new KorisnikDTO(korisnik.getId(), korisnik.getIme(), korisnik.getPrezime(), korisnik.getPosition(),
                korisnik.getUsername(), korisnik.getEmail(), korisnik.getTelefon(), korisnik.getDatum(), korisnik.getAktivan(),
                korisnik.getPassword());

        return new ResponseEntity<>(retDTO, HttpStatus.OK);
    }

    /*update postojeceg korisnika*/
   /* @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> updateKorisnik(@PathVariable Long id,@RequestBody KorisnikDTO korisnikDTO) throws Exception{
        Korisnik korisnik = new Korisnik(korisnikDTO.getIme(),korisnikDTO.getPrezime(),korisnikDTO.getPosition(),
                korisnikDTO.getUsername(),korisnikDTO.getEmail(),korisnikDTO.getTelefon(),korisnikDTO.getDatum(),korisnikDTO.getAktivan(),
                korisnikDTO.getPassword());
        korisnik.setId(id);

        Korisnik updatedKo = korisnikService.update(korisnik);

        KorisnikDTO updatedKoDTO = new KorisnikDTO(updatedKo.getId(),updatedKo.getIme(),updatedKo.getPrezime(),updatedKo.getPosition(),updatedKo.getUsername(),
                updatedKo.getEmail(), updatedKo.getTelefon(),updatedKo.getDatum(),updatedKo.getAktivan(), updatedKo.getPassword());

        return new ResponseEntity<>(updatedKoDTO,HttpStatus.OK);
    }*/
   @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Korisnik user, @PathVariable Long id) {
        try {
            Korisnik existUser = korisnikService.getUser(id);
            user.setId(id);
            korisnikService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/terms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTerms(){

        List<Trening> trainingList = this.treningService.findAll();
        List<TreningDTO> trainingDTOS = new ArrayList<>();

        for (Trening training : trainingList) {
            TreningDTO trainingDTO = new TreningDTO();
            trainingDTO.setId(training.getId());
            trainingDTO.setNaziv(training.getNaziv());
            trainingDTO.setOpis(training.getOpis());
            trainingDTO.setTipTreninga(training.getTipTreninga());
            trainingDTO.setTrajanje(training.getTrajanje());
            List<TerminskaListaDTO> listTermsDTO = new ArrayList<>();
            for(TerminskaLista terms : training.getTerminskaListas()){
                TerminskaListaDTO termsDTO = new TerminskaListaDTO();
                termsDTO.setId(terms.getId());
                termsDTO.setCena(terms.getCena());
                termsDTO.setDan(terms.getDan());
                listTermsDTO.add(termsDTO);
            }
            trainingDTO.setTerminskaListaDTOS(listTermsDTO);
            trainingDTOS.add(trainingDTO);
        }
        return new ResponseEntity<>(trainingDTOS, HttpStatus.OK);
    }
/*
    @PostMapping("/odabitTreninga")
    public ResponseEntity<?> reserve_ticket(@RequestBody PrijavaDTO prijavaDTO){
        boolean flag=false;
        try {
            flag=this.korisnikService.addTrening(prijavaDTO.getKorisnik_id(),prijavaDTO.getTerminskaLista_id());
            if(flag)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    /*brisanje korisnika*/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id){
        this.korisnikService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
/*
    @PostMapping(value = "/add_trening")
    public ResponseEntity<?> add_trening(@RequestBody TreningDTO treningDTO) {
        try {
            this.treningService.addTrening(treningDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }*/



}
