package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {

    List<Korisnik> findAllByPositionOrderByIme(String position);


    List<Korisnik> findByImeOrPrezime(String ime, String prezime);


    List<Korisnik> findByImeIgnoreCase(String ime);


    List<Korisnik> findByFitnessCentarNaziv(String Naziv);

    Korisnik findByEmail(String email);

}

