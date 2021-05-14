package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Integer kapacitet;

    @Column
    private Integer oznakaSale;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

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

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public Integer getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(Integer oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
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
        return "Sala{" +
                "id=" + id +
                ", kapacitet=" + kapacitet +
                ", oznakaSale=" + oznakaSale +
                ", fitnessCentar=" + fitnessCentar +
                ", trening=" + trening +
                ", cene=" + cene +
                '}';
    }
}
