package com.example.FitnessCetnar.service.impl;
import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.dto.KorisnikDTO;
import com.example.FitnessCetnar.repository.KorisnikRepository;
import com.example.FitnessCetnar.service.KorisnikService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {


    private  final KorisnikRepository korisnikRepository;


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

    @Override
    public Korisnik save(Korisnik korisnik) {
        return this.korisnikRepository.save(korisnik);
    }


    @Override
    public void delete(Long id){this.korisnikRepository.deleteById(id);}
}
