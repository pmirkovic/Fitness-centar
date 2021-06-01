package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    /*Korisnik findByEmail(String email);

    List<Korisnik> findByPosition(Position position);*/
    List<Korisnik> findAllByPositionOrderByIme(String position);

    /*
        Traži sve zaposlene po imenu ili prezimenu.
     */
    List<Korisnik> findByImeOrPrezime(String ime, String prezime);

    /*
        Traži sve zaposlene po imenu, ignorišu se mala i velika slova.
     */
    List<Korisnik> findByImeIgnoreCase(String ime);

    /*
        Traži sve zaposlene po nazivu departmana.
     */
    List<Korisnik> findByFitnessCentarNaziv(String Naziv);
}

