package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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
    private TerminskaLista trening;



    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Sala_treninzi",
    joinColumns = @JoinColumn(name = "sala_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id"))
    private List<Trening> trenings = new ArrayList<>();


    public Sala(Integer kapacitet, Integer salaDTOKapacitet, Trening trening, FitnessCentar centar) {
    }


    public FitnessCentar getFitnesCentar(){return  fitnessCentar;}
    public void setFitnesCentar(FitnessCentar fitnessCentar){this.fitnessCentar=fitnessCentar;}
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

    public List<Trening> getTrenings() {
        return trenings;
    }

    public TerminskaLista getTrening() {
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


    public void setTrenings(List<Trening> trenings) {
        this.trenings = trenings;
    }

    public void setTrening(TerminskaLista trening) {
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
                ", trenings=" + trenings +
                '}';
    }
}
