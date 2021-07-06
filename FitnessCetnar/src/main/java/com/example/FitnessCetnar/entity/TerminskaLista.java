package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class TerminskaLista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String dan;

    @Column
    private Double cena;

    @Column
    private Integer brojClanova;

    /*----------------------------------------------------------------------*/

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Trening trening;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    public TerminskaLista() {
    }

    /*----------------------------------------------------------------------*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getBrojClanova() {
        return brojClanova;
    }

    public void setBrojClanova(Integer brojClanova) {
        this.brojClanova = brojClanova;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }

    /*----------------------------------------------------------------------*/

    public TerminskaLista(long id, String dan, Double cena, Integer brojClanova, Sala sala, Trening trening, FitnessCentar fitnessCentar) {
        this.id = id;
        this.dan = dan;
        this.cena = cena;
        this.brojClanova = brojClanova;
        this.sala = sala;
        this.trening = trening;
        this.fitnessCentar = fitnessCentar;
    }
/*
    @Override
    public String toString() {
        return "TerminskaLista{" +
                "id=" + id +
                ", dan='" + dan + '\'' +
                ", cena=" + cena +
                ", brojClanova=" + brojClanova +
                ", fitnessCentar=" + fitnessCentar +
                '}';
    }
    */

}
