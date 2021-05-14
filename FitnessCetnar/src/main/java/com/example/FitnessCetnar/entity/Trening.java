package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    @ManyToMany(mappedBy = "ListaOdradjenihTreninga")
    private List<ClanFitnesCentra> Odradjenih = new ArrayList<>();

    @ManyToMany(mappedBy = "ListaPrijavljenihTreninga")
    private List<ClanFitnesCentra> Prijavljenih = new ArrayList<>();

    @ManyToMany(mappedBy = "OcenaOdradjenihTreninga")
    private List<ClanFitnesCentra> Ocena = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;
    @ManyToOne(fetch = FetchType.EAGER)
    private Trening cene;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public List<ClanFitnesCentra> getOdradjenih() {
        return Odradjenih;
    }

    public void setOdradjenih(List<ClanFitnesCentra> odradjenih) {
        Odradjenih = odradjenih;
    }

    public List<ClanFitnesCentra> getPrijavljenih() {
        return Prijavljenih;
    }

    public void setPrijavljenih(List<ClanFitnesCentra> prijavljenih) {
        Prijavljenih = prijavljenih;
    }

    public List<ClanFitnesCentra> getOcena() {
        return Ocena;
    }

    public void setOcena(List<ClanFitnesCentra> ocena) {
        Ocena = ocena;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Trening getCene() {
        return cene;
    }

    public void setCene(Trening cene) {
        this.cene = cene;
    }

    @Override
    public String toString() {
        return "Trening{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", tipTreninga='" + tipTreninga + '\'' +
                ", Trajanje=" + Trajanje +
                ", trener=" + trener +
                ", Odradjenih=" + Odradjenih +
                ", Prijavljenih=" + Prijavljenih +
                ", Ocena=" + Ocena +
                ", trening=" + trening +
                ", cene=" + cene +
                '}';
    }
}
