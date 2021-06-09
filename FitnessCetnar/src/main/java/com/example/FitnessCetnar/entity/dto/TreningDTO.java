package com.example.FitnessCetnar.entity.dto;

import com.example.FitnessCetnar.entity.TerminskaLista;
import com.example.FitnessCetnar.entity.Trening;

import java.util.List;
import java.util.Set;

public class TreningDTO {
    
    private Long id;
    private String naziv;
    private String opis;
    private Double trajanje;
    private Double cena;
    private String tipTreninga;
    private Set<TerminskaListaDTO> terminskaListaDTOS;


    public TreningDTO(Long id, String naziv, String opis, Double trajanje, Double cena, String tipTreninga, Set<TerminskaListaDTO> terminskaListaDTOS) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.trajanje = trajanje;
        this.cena = cena;
        this.tipTreninga = tipTreninga;
        this.terminskaListaDTOS = terminskaListaDTOS;
    }

    public TreningDTO(Long id, String naziv, String opis, Double cena, Double trajanje, String tipTreninga) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.trajanje = trajanje;
        this.cena = cena;
        this.tipTreninga = tipTreninga;
    }

    public TreningDTO() {

    }


    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
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

    public Set<TerminskaListaDTO> getTerminskaListaDTOS() {
        return terminskaListaDTOS;
    }

    public void setTerminskaListaDTOS(Set<TerminskaListaDTO> terminskaListaDTOS) {
        this.terminskaListaDTOS = terminskaListaDTOS;
    }
}
