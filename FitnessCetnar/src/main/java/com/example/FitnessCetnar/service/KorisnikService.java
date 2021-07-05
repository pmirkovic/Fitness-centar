package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.*;
import com.example.FitnessCetnar.entity.dto.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface KorisnikService{



    Korisnik findOne(Long id);

    List<Korisnik> findAll();

    Korisnik create(Korisnik employee) throws Exception;

    Korisnik update(Korisnik employee) throws Exception;

    void delete(Long id);

    boolean login(KorisnikDTO korisnikDTO, Korisnik korisnik);

    void saveUser(Korisnik user);

    Korisnik getUser(Long id);
    void editKorisnik(Korisnik korisnik);

    public boolean addTrening(Long korisnik_id,Long trening_id);

    Korisnik checkEmail(KorisnikDTO korisnikDTO)  throws Exception;
    public Korisnik save(Korisnik korisnik) throws Exception;


}
