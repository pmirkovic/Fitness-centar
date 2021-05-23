package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Trener implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Korisnik korisnik;


    @OneToMany(mappedBy="trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Trening> ListaTreningaKojeDrzi = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    /*----------------------------------------------------------------------*/

    public Long getId() {
        return id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public List<Trening> getListaTreningaKojeDrzi() {
        return ListaTreningaKojeDrzi;
    }

    /*----------------------------------------------------------------------*/

    public void setId(Long id) {
        this.id = id;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public void setListaTreningaKojeDrzi(List<Trening> listaTreningaKojeDrzi) {
        ListaTreningaKojeDrzi = listaTreningaKojeDrzi;
    }

    /*----------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Trener{" +
                "id=" + id +
                ", korisnik=" + korisnik +
                ", ListaTreningaKojeDrzi=" + ListaTreningaKojeDrzi +
                '}';
    }
}
