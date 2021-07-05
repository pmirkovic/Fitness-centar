package com.example.FitnessCetnar.service.impl;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Sala;
import com.example.FitnessCetnar.entity.TerminskaLista;
import com.example.FitnessCetnar.entity.Trening;
import com.example.FitnessCetnar.entity.dto.KorisnikDTO;
import com.example.FitnessCetnar.repository.KorisnikRepository;
import com.example.FitnessCetnar.repository.TerminskaListaRepository;
import com.example.FitnessCetnar.service.KorisnikService;
import com.example.FitnessCetnar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class KorisnikServiceImpl implements KorisnikService {

/*
    @Autowired
    private KorisnikRepository korisnikRepository;*/


    private  final KorisnikRepository korisnikRepository;


    public KorisnikServiceImpl(KorisnikRepository korisnikRepository){this.korisnikRepository=korisnikRepository;}

    @Autowired
    private TreningService treningService;

    @Override
    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.getOne(id);
        return korisnik;
    }

    @Override
    public List<Korisnik> findAll() {
        List<Korisnik> korisniks = this.korisnikRepository.findAll();
        return korisniks;
    }

    @Override
    public Korisnik create(Korisnik korisnik)throws Exception{
        if(korisnik.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Korisnik newKorisnik = this.korisnikRepository.save(korisnik);
        return newKorisnik;
    }

    @Override
    public Korisnik update(Korisnik korisnik) throws Exception{
        Korisnik korisnikToUpdate = this.korisnikRepository.getOne(korisnik.getId());
        if(korisnikToUpdate == null){
            throw new Exception("Korisnik doesn't exist!");
        }
        korisnikToUpdate.setPosition(korisnik.getPosition());

        Korisnik savedKo = this.korisnikRepository.save(korisnikToUpdate);
        return savedKo;
    }

    @Override
    public boolean login(KorisnikDTO korisnikDTO, Korisnik korisnik) {
        if(korisnik.getPassword().equals(korisnikDTO.getPassword())){
            return  true;
        }
        return false;
    }
    @Override
    public Korisnik checkEmail(KorisnikDTO korisnikDTO) {
        Korisnik korisnik = this.korisnikRepository.findByEmail(korisnikDTO.getEmail());
        if (korisnik == null)
            return null;
        return korisnik;
    }

    public Korisnik getUser(Long id) {
        return korisnikRepository.findById(id).get();
    }

    public void saveUser(Korisnik user) {
        korisnikRepository.save(user);
    }

    public void editKorisnik(Korisnik korisnik) {
        this.korisnikRepository.updateKorisnik(korisnik.getId(),korisnik.getIme(), korisnik.getPrezime(), korisnik.getPosition(),
                korisnik.getUsername(), korisnik.getEmail(), korisnik.getTelefon(), korisnik.getDatum(), korisnik.getAktivan(),
                korisnik.getPassword());
    }

    public boolean addTrening(Long korisnik_id,Long trening_id){
        Korisnik korisnik = this.korisnikRepository.findById(korisnik_id).get();
        Trening trening = this.treningService.findOne(trening_id);
        if(korisnik.getPrijava_treninga().contains(trening)){
            return false;
        }

        for(Sala sala:trening.getSalas()){
            if(sala.getKapacitet()-trening.getKorisniks().size()>0){
                korisnik.getPrijava_treninga().add(trening);
                return true;
            }
        }
        return false;
    }


    @Override
    public Korisnik save(Korisnik korisnik) {
        return this.korisnikRepository.save(korisnik);
    }


    @Override
    public void delete(Long id){this.korisnikRepository.deleteById(id);}
}
