package com.example.FitnessCetnar.service.impl;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.repository.KorisnikRepository;
import com.example.FitnessCetnar.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
@Service
public class KorisnikServiceImpl implements KorisnikService {

    private  final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository){this.korisnikRepository=korisnikRepository;}

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
    public void delete(Long id){this.korisnikRepository.deleteById(id);}
}*/
