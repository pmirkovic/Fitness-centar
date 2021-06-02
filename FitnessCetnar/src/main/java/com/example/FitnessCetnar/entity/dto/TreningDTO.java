package com.example.FitnessCetnar.entity.dto;

import com.example.FitnessCetnar.entity.Trening;

import java.util.List;

public class TreningDTO {
    
    private Long id;
    private String naziv;
    private String opis;
    private Double trajanje;
    private Double cena;


    public TreningDTO(Long id, String naziv, String opis, String tipTreninga, Double trajanje) {
    }

    public TreningDTO(Long id, String naziv, String opis, Double cena, Double trajanje) {

    }

    public TreningDTO() {

    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

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

    public Double getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Double trajanje) {
        this.trajanje = trajanje;
    }

    private List<Trening> treningList;
    private List<String> tipTreninga;

    public List<Trening> getTreningList() {
        return treningList;
    }

    public void setTreningList(List<Trening> treningList) {
        this.treningList = treningList;
    }

    public List<String> getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(List<String> tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public TreningDTO(List<Trening> treningList, List<String> tipTreninga) {
        this.treningList = treningList;
        this.tipTreninga = tipTreninga;
    }
}
