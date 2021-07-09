package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Prijava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long> {

    List<Prijava> findByKorisnik_Id(Long id);
}
