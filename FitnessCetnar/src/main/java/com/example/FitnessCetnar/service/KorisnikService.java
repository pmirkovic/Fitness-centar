package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.*;
import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.entity.dto.KorisnikDTO;
import com.example.FitnessCetnar.entity.dto.SalaDTO;
import com.example.FitnessCetnar.entity.dto.TrenerDTO;
import com.example.FitnessCetnar.repository.KorisnikRepository;
import com.example.FitnessCetnar.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;



public interface KorisnikService{

   /* @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private FitnescentarService fitnescentarService;
    @Autowired
    private SalaService salaService;
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private TreningRepository treningRepository;
    @Autowired
    private TreningService treningService;

    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.findById(id).get();
        return korisnik;
    }
    public List<Korisnik> findAll(){
        List<Korisnik> korisniks = this.korisnikRepository.findAll();
        return korisniks;
    }
    public Korisnik save(Korisnik korisnik){return this.korisnikRepository.save(korisnik);}

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

    public void editFitnescentar(FitnessCentar fitnessCentar){this.fitnescentarService.editFitnescentar(fitnessCentar);}

    public void addFitnrescentar(FitnescentarDTO fitnescentarDTO){
        FitnessCentar fitnessCentar = new FitnessCentar(fitnescentarDTO.getAdresa(),fitnescentarDTO.getBrTelefona(),fitnescentarDTO.getNaziv(),fitnescentarDTO.getEmail());
        this.fitnescentarService.save(fitnessCentar);
    }

    public void addSala(SalaDTO salaDTO){
        FitnessCentar fitnessCentar=this.fitnescentarService.findOne(salaDTO.getFitness_centar_id());
        Sala sala=new Sala(salaDTO.getOznakaSale(),salaDTO.getKapacitet(),null,fitnessCentar);
    }
    public void editSala(Sala sala){this.salaService.editSala(sala);}

    public List<Korisnik> getTrener() {
        return this.korisnikRepository.findByPosition(Position.TRENER);
    }

    public void saveTrener(TrenerDTO trenerDTO){
        FitnessCentar fitnessCentar = fitnescentarService.findOne(trenerDTO.getFitness_centar_id());
        Korisnik korisnik = new Korisnik(trenerDTO.getIme(),trenerDTO.getPrezime(),trenerDTO.getAktivan(),trenerDTO.getDatum(),
                trenerDTO.getPassword(),trenerDTO.getEmail(),trenerDTO.getTelefon(),trenerDTO.getPosition(),trenerDTO.getUsername(),fitnessCentar);
        this.korisnikRepository.save(korisnik);
    }
    public void deleteKorisnik(Long id){
        this.korisnikRepository.deleteById(id);
    }

    public boolean addPrijava_treninga(Long korisnik_id,Long trening_id){
        Korisnik korisnik=this.korisnikRepository.findById(korisnik_id).get();
        Trening trening = this.treningService.findOne(trening_id);
        if(korisnik.getPrijava_treninga().contains(trening)){
            return false;
        }
        for(Sala sala: trening.getSalas()){
            if(sala.getKapacitet()-trening.getKorisniks().size()>0){
                korisnik.getPrijava_treninga().add(trening);
                return true;
            }
        }
        return false;
    }

    public void otkazivanjeTreninga(Long korsinik_id,Long trening_id){
        Korisnik korisnik = this.korisnikRepository.findById(korsinik_id).get();
        Trening trening = this.treningService.findOne(trening_id);
        korisnik.getPrijava_treninga().remove(trening);
        return;
    }*/


    Korisnik findOne(Long id);

    List<Korisnik> findAll();

    Korisnik create(Korisnik employee) throws Exception;

    Korisnik update(Korisnik employee) throws Exception;

    void delete(Long id);

}
