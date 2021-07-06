package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Trening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Column
    private String tipTreninga;

    @Column
    private Double Trajanje;

    @Column
    private Double rating;

    @Column
    private Double cena;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;


    @JsonIgnore
    @ManyToMany(mappedBy="prijava_treninga")
    private Set<Korisnik> korisniks=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="trening",fetch=FetchType.EAGER,orphanRemoval=true)
    Set<Odradjeni_treninzi> odradjeni_treninzis=new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy="trenings",cascade=CascadeType.ALL)
    private List<Sala> salas=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="trening",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    Set<TerminskaLista> terminskaListas=new HashSet<>();



    public Trening(String naziv, String opis, Double cena, Double treningDTOCena) {
    }

    public Trening(String naziv, String opis, Double cena, Double trajanje, String tipTreninga) {
    }

    /*----------------------------------------------------------------------*/

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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public Double getTrajanje() {
        return Trajanje;
    }

    public void setTrajanje(Double trajanje) {
        Trajanje = trajanje;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }


    public Set<Korisnik> getKorisniks() {
        return korisniks;
    }

    public void setKorisniks(Set<Korisnik> korisniks) {
        this.korisniks = korisniks;
    }

    public Set<Odradjeni_treninzi> getOdradjeni_treninzis() {
        return odradjeni_treninzis;
    }

    public void setOdradjeni_treninzis(Set<Odradjeni_treninzi> odradjeni_treninzis) {
        this.odradjeni_treninzis = odradjeni_treninzis;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public Set<TerminskaLista> getTerminskaListas() {
        return terminskaListas;
    }

    public void setTerminskaListas(Set<TerminskaLista> terminskaListas) {
        this.terminskaListas = terminskaListas;
    }

    /*----------------------------------------------------------------------*/

    public Trening(Long id, String naziv, String opis, String tipTreninga, Double trajanje, Double rating, Double cena, Trener trener,  Set<Korisnik> korisniks, Set<Odradjeni_treninzi> odradjeni_treninzis, List<Sala> salas, Set<TerminskaLista> terminskaListas) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        Trajanje = trajanje;
        this.rating = rating;
        this.cena = cena;
        this.trener = trener;
        this.korisniks = korisniks;
        this.odradjeni_treninzis = odradjeni_treninzis;
        this.salas = salas;
        this.terminskaListas = terminskaListas;
    }

    public Trening() {
    }
}
