package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy="trening",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Sala> treninzi = new ArrayList<>();
    @OneToMany(mappedBy="cene",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Trening> cene = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    public TerminskaLista() {
    }

    /*----------------------------------------------------------------------*/

    public long getId() {
        return id;
    }

    public String getDan() {
        return dan;
    }

    public Double getCena() {
        return cena;
    }

    public Integer getBrojClanova() {
        return brojClanova;
    }

    public List<Sala> getTreninzi() {
        return treninzi;
    }

    public List<Trening> getCene() {
        return cene;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    /*----------------------------------------------------------------------*/

    public void setId(long id) {
        this.id = id;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public void setBrojClanova(Integer brojClanova) {
        this.brojClanova = brojClanova;
    }

    public void setTreninzi(List<Sala> treninzi) {
        this.treninzi = treninzi;
    }

    public void setCene(List<Trening> cene) {
        this.cene = cene;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }

    /*----------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "TerminskaLista{" +
                "id=" + id +
                ", dan='" + dan + '\'' +
                ", cena=" + cena +
                ", brojClanova=" + brojClanova +
                ", treninzi=" + treninzi +
                ", cene=" + cene +
                ", fitnessCentar=" + fitnessCentar +
                '}';
    }
}
