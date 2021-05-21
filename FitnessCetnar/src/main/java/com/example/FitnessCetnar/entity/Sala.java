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

    /*----------------------------------------------------------------------*/

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;
    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;


    public Sala() {
    }

    /*----------------------------------------------------------------------*/

    public long getId() {
        return id;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public Integer getOznakaSale() {
        return oznakaSale;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public Trening getTrening() {
        return trening;
    }

    /*----------------------------------------------------------------------*/

    public void setId(long id) {
        this.id = id;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public void setOznakaSale(Integer oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    /*----------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", kapacitet=" + kapacitet +
                ", oznakaSale=" + oznakaSale +
                ", fitnessCentar=" + fitnessCentar +
                ", trening=" + trening +
                '}';
    }
}
