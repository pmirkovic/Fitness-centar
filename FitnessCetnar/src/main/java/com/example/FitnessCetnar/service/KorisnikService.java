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



    Korisnik findOne(Long id);

    List<Korisnik> findAll();

    Korisnik create(Korisnik employee) throws Exception;

    Korisnik update(Korisnik employee) throws Exception;

    void delete(Long id);

    boolean login(KorisnikDTO korisnikDTO,Korisnik korisnik);

    Korisnik checkEmail(KorisnikDTO korisnikDTO)  throws Exception;
    public Korisnik save(Korisnik user) throws Exception;

}
