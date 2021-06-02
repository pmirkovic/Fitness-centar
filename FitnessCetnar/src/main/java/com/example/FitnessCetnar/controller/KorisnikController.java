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

import java.util.ArrayList;
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

    @GetMapping("/pocetna")
    public String pocetna(){return "pocetna.html";}

    @GetMapping("/registracija_trenera")
    public String registracija_trenera() {return "registracija_trenera.html";}


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody KorisnikDTO korisnikDTO){
        Korisnik korisnik;
        try{
            korisnik=this.korisnikService.proveraEmail(korisnikDTO);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        if(korisnik == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!(this.korisnikService.login(korisnikDTO,korisnik))){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Korisnik>(korisnik,HttpStatus.OK);
    }

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

    @GetMapping("/account/{id}/registracija_trenera")
    public String registracija_trenera(@PathVariable(name = "id") Long id, Model model){
        List<FitnessCentar> fitnessCentarList = this.fitnescentarService.findAll();
        Korisnik korisnik=this.korisnikService.findOne(id);
        model.addAttribute("fitnes", fitnessCentarList);
        model.addAttribute("korisnik",korisnik);
        return "registracija_trenera.html";
    }

    @GetMapping("/odobrenje_trenera")
    public String odobrenje_trenera(@PathVariable(name = "id") Long id, Model model){
        List<FitnessCentar> fitnessCentarList = this.fitnescentarService.findAll();
        Korisnik korisnik=this.korisnikService.findOne(id);
        model.addAttribute("fitnes", fitnessCentarList);
        model.addAttribute("korisnik",korisnik);
        return "odobrenje_trenera.html";
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

    @GetMapping("/account/{id}")
    public String account(@PathVariable(name = "id") Long id,Model model){
        Korisnik korisnik = this.korisnikService.findOne(id);
        model.addAttribute("korisnik",korisnik);
        return "account.html";
    }

    @GetMapping("/account/{id}/odradjeni_treninzi")
    public String odradjeni_treninzi(@PathVariable(name = "id")Long id,Model model){
        Korisnik korisnik=this.korisnikService.findOne(id);
        model.addAttribute("korisnik",korisnik);
        return "odradjeni_trenizni.html";
    }
    @GetMapping("/account/{id}/trener")
    public String trener(@PathVariable(name = "id")Long id,Model model){
        List<Korisnik>korisniks=this.korisnikService.getTrener();
        Korisnik korisnik=this.korisnikService.findOne(id);
        model.addAttribute("trener",korisniks);
        model.addAttribute("korsnik",korisnik);
        return "trener.html";
    }


    @PostMapping("/prijava_treninga")
    public ResponseEntity<?> prijava_treninga(@RequestBody Prijava_treningaDTO prijava_treningaDTO){
        boolean flag=false;
        try{
            flag = this.korisnikService.addPrijava_treninga(prijava_treningaDTO.getKorisnik_id(),prijava_treningaDTO.getTrening_id());
            if(flag)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/otkazivanje_treninga")
    public ResponseEntity<?> otkazivanje(@RequestBody Prijava_treningaDTO prijava_treningaDTO){
        try {
            this.korisnikService.otkazivanjeTreninga(prijava_treningaDTO.getKorisnik_id(),prijava_treningaDTO.getTrening_id());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable("id") Long id){
        Korisnik korisnik = this.korisnikService.findOne(id);

        KorisnikDTO korisnikDTO = new KorisnikDTO();

        korisnikDTO.setId(korisnik.getId());
        korisnikDTO.setIme(korisnik.getIme());
        korisnikDTO.setPrezime(korisnik.getPrezime());
        korisnikDTO.setPosition(korisnik.getPosition());
        korisnikDTO.setPassword(korisnik.getPassword());
        korisnikDTO.setAktivan(korisnik.getAktivan());
        korisnikDTO.setTelefon(korisnik.getTelefon());
        korisnikDTO.setDatum(korisnik.getDatum());
        korisnikDTO.setEmail(korisnik.getEmail());


        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getKorisniks(){
        List<Korisnik> korisnikList = this.korisnikService.findAll();

        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

        for (Korisnik korisnik : korisnikList){
            KorisnikDTO korisnikDTO=new KorisnikDTO(korisnik.getId(),korisnik.getIme(),korisnik.getPrezime(),korisnik.getPosition(),
                                korisnik.getPassword(),korisnik.getAktivan(),korisnik.getDatum(), korisnik.getEmail(), korisnik.getTelefon());
            korisnikDTOS.add(korisnikDTO);
        }

        return new ResponseEntity<>(korisnikDTOS,HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> createKorisnik(@RequestBody KorisnikDTO korisnikDTO) throws Exception{
        Korisnik korisnik = new Korisnik(korisnikDTO.getIme(),korisnikDTO.getPrezime(),korisnikDTO.getPosition(),
                korisnikDTO.getDatum(),korisnikDTO.getAktivan(),korisnikDTO.getUsername(),korisnikDTO.getTelefon(),
                korisnikDTO.getEmail(),korisnikDTO.getPassword());

        Korisnik newKorisnik = korisnikService.create(korisnik);

        KorisnikDTO newKorisnikDTO = new KorisnikDTO(newKorisnik.getId(),newKorisnik.getIme(),newKorisnik.getPrezime(),newKorisnik.getPosition(),
                newKorisnik.getPassword(),newKorisnik.getAktivan(),newKorisnik.getDatum(),newKorisnik.getEmail(),newKorisnik.getTelefon());

        return new ResponseEntity<>(newKorisnikDTO,HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> updateKorisnik(@PathVariable Long id,@RequestBody KorisnikDTO korisnikDTO) throws Exception{
        Korisnik korisnik = new Korisnik(korisnikDTO.getIme(),korisnikDTO.getPrezime(),korisnikDTO.getPosition(),
                korisnikDTO.getDatum(),korisnikDTO.getAktivan(),korisnikDTO.getUsername(),korisnikDTO.getTelefon(),
                korisnikDTO.getEmail(),korisnikDTO.getPassword());
        korisnik.setId(id);

        Korisnik updatedKo = korisnikService.update(korisnik);

        KorisnikDTO updatedKoDTO = new KorisnikDTO(updatedKo.getId(),updatedKo.getIme(),updatedKo.getPrezime(),updatedKo.getPosition(),updatedKo.getPassword(),
                updatedKo.getAktivan(),updatedKo.getDatum(),updatedKo.getEmail(),updatedKo.getTelefon());

        return new ResponseEntity<>(updatedKoDTO,HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id){
        this.korisnikService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

}
