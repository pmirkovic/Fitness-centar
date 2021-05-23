package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    Korisnik findByEmail(String email);

    List<Korisnik> findByPosition(Position position);
}
