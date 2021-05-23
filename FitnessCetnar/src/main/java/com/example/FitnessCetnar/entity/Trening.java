package com.example.FitnessCetnar.entity;

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
    private long id;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    @ManyToMany(mappedBy = "ListaOdradjenihTreninga")
    private List<ClanFitnesCentra> Odradjenih = new ArrayList<>();
    @ManyToMany(mappedBy = "ListaPrijavljenihTreninga")
    private List<ClanFitnesCentra> Prijavljenih = new ArrayList<>();
    @ManyToMany(mappedBy = "OcenaOdradjenihTreninga")
    private List<ClanFitnesCentra> Ocena = new ArrayList<>();

    @ManyToMany(mappedBy="trenings",cascade=CascadeType.ALL)
    private List<Sala> salas=new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private TerminskaLista trening;
    @ManyToOne(fetch = FetchType.EAGER)
    private TerminskaLista cene;

    public Trening() {
    }

    /*----------------------------------------------------------------------*/

    public long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public Double getTrajanje() {
        return Trajanje;
    }

    public Trener getTrener() {
        return trener;
    }

    public List<ClanFitnesCentra> getOdradjenih() {
        return Odradjenih;
    }

    public List<ClanFitnesCentra> getPrijavljenih() {
        return Prijavljenih;
    }

    public List<ClanFitnesCentra> getOcena() {
        return Ocena;
    }

    public TerminskaLista getTrening() {
        return trening;
    }

    public TerminskaLista getCene() {
        return cene;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public Double getRating() {
        return rating;
    }

    /*----------------------------------------------------------------------*/

    public void setId(long id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public void setTrajanje(Double trajanje) {
        Trajanje = trajanje;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public void setOdradjenih(List<ClanFitnesCentra> odradjenih) {
        Odradjenih = odradjenih;
    }

    public void setPrijavljenih(List<ClanFitnesCentra> prijavljenih) {
        Prijavljenih = prijavljenih;
    }

    public void setOcena(List<ClanFitnesCentra> ocena) {
        Ocena = ocena;
    }

    public void setTrening(TerminskaLista trening) {
        this.trening = trening;
    }

    public void setCene(TerminskaLista cene) {
        this.cene = cene;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    /*----------------------------------------------------------------------*/


}
