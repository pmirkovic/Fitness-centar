package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class FitnessCentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String adresa;

    @Column
    private Integer brTelefona;

    @Column
    private String email;

    //trener

    //Lista Sala

    //Raspored Treninga


    @OneToMany(mappedBy="FitnessCentar",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Korisnik> korisnik = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(Integer brTelefona) {
        this.brTelefona = brTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Korisnik> getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(List<Korisnik> korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String toString() {
        return "FitnessCentar{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brTelefona=" + brTelefona +
                ", email='" + email + '\'' +
                ", korisnik=" + korisnik +
                '}';
    }
}
