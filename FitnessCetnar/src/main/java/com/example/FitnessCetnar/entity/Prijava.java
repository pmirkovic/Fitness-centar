package com.example.FitnessCetnar.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Prijava implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik korisnik;

    @ManyToOne(fetch = FetchType.EAGER)
    private TerminskaLista termin;

    public Prijava() {
    }

    public Prijava(Long id, Korisnik korisnik, TerminskaLista termin) {
        this.id = id;
        this.korisnik = korisnik;
        this.termin = termin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public TerminskaLista getTermin() {
        return termin;
    }

    public void setTermin(TerminskaLista termin) {
        this.termin = termin;
    }




}
