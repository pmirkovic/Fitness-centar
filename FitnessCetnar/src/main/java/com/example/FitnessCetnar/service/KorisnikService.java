package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.FitnessCentar;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Sala;
import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.entity.dto.KorisnikDTO;
import com.example.FitnessCetnar.entity.dto.SalaDTO;
import com.example.FitnessCetnar.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private FitnescentarService fitnescentarService;
    @Autowired
    private SalaService salaService;
    /*Korisnik*/
    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.findById(id).get();
        return korisnik;
    }
    public List<Korisnik> findAll(){
        List<Korisnik> korisniks = this.korisnikRepository.findAll();
        return korisniks;
    }
    public Korisnik save(Korisnik korisnik){return this.korisnikRepository.save(korisnik);}
    /*----------*/
    /*Login*/
    public boolean login(KorisnikDTO korisnikDTO,Korisnik korisnik){
        if(korisnik.getPassword().equals(korisnikDTO.getPassword())){
            return true;
        }
        return false;
    }
    public Korisnik proveraEmail(KorisnikDTO korisnikDTO){
        Korisnik korisnik = this.korisnikRepository.findByEmail(korisnikDTO.getEmail());
        if(korisnik==null)
            return null;
        return korisnik;
    }
    /*----------*/
    /**/
    public void editFitnescentar(FitnessCentar fitnessCentar){this.fitnescentarService.editFitnescentar(fitnessCentar);}

    public void addFitnrescentar(FitnescentarDTO fitnescentarDTO){
        FitnessCentar fitnessCentar = new FitnessCentar(fitnescentarDTO.getAdresa(),fitnescentarDTO.getBrTelefona(),fitnescentarDTO.getNaziv(),fitnescentarDTO.getEmail());
        this.fitnescentarService.save(fitnessCentar);
    }
    /*----------*/
    /**/
    public void addSala(SalaDTO salaDTO){
        FitnessCentar fitnessCentar=this.fitnescentarService.findOne(salaDTO.getFitness_centar_id());
        Sala sala=new Sala(salaDTO.getOznakaSale(),salaDTO.getKapacitet(),null,fitnessCentar);
    }
    public void editSala(Sala sala){this.salaService.editSala(sala);}
    /*----------*/
}
