package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Sala;
import com.example.FitnessCetnar.entity.Trener;
import com.example.FitnessCetnar.entity.dto.*;
import com.example.FitnessCetnar.service.FitnescentarService;
import com.example.FitnessCetnar.service.KorisnikService;
import com.example.FitnessCetnar.service.SalaService;
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

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {

    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
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
    public ResponseEntity<?> login(@RequestBody KorisnikDTO korisnikDTO){
        Korisnik korisnik;
        try {
            korisnik=this.korisnikService.checkEmail(korisnikDTO);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        if(korisnik==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!(this.korisnikService.login(korisnikDTO, korisnik))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
    }

    /*update postojeceg korisnika*/
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> updateKorisnik(@PathVariable Long id,@RequestBody KorisnikDTO korisnikDTO) throws Exception{
        Korisnik korisnik = new Korisnik(korisnikDTO.getIme(),korisnikDTO.getPrezime(),korisnikDTO.getPosition(),
                korisnikDTO.getUsername(),korisnikDTO.getEmail(),korisnikDTO.getTelefon(),korisnikDTO.getDatum(),korisnikDTO.getAktivan(),
                korisnikDTO.getPassword());
        korisnik.setId(id);

        Korisnik updatedKo = korisnikService.update(korisnik);

        KorisnikDTO updatedKoDTO = new KorisnikDTO(updatedKo.getId(),updatedKo.getIme(),updatedKo.getPrezime(),updatedKo.getPosition(),updatedKo.getUsername(),
                updatedKo.getEmail(), updatedKo.getTelefon(),updatedKo.getDatum(),updatedKo.getAktivan(), updatedKo.getPassword());

        return new ResponseEntity<>(updatedKoDTO,HttpStatus.OK);
    }


    /*brisanje korisnika*/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id){
        this.korisnikService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
