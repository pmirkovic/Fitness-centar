/*package com.example.FitnessCetnar.controller;

import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Trener;
import com.example.FitnessCetnar.entity.dto.KorisnikDTO;
import com.example.FitnessCetnar.entity.dto.TrenerDTO;
import com.example.FitnessCetnar.service.KorisnikService;
import com.example.FitnessCetnar.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class TrenerController {



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register_trenera(@RequestBody Trener trener) {
        Trener trener1;
        try {
            trener1=trenerService.save(trener);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Trener>(user1, HttpStatus.OK);
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
    }
}
*/