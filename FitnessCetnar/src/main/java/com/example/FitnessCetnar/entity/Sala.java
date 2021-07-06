package com.example.FitnessCetnar.entity;

import com.example.FitnessCetnar.entity.dto.FitnescentarDTO;
import com.example.FitnessCetnar.entity.dto.SalaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @JsonIgnore
    @OneToMany(mappedBy="sala",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    Set<TerminskaLista> terminskaListas=new HashSet<>();

    public Sala(Integer kapacitet, Integer oznakaSale) {
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
    }

    public FitnessCentar getFitnesCentar(){return  fitnessCentar;}
    public void setFitnesCentar(FitnessCentar fitnessCentar){this.fitnessCentar=fitnessCentar;}
    /*----------------------------------------------------------------------*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public TerminskaLista getTrening() {
        return trening;
    }

    public void setTrening(TerminskaLista trening) {
        this.trening = trening;
    }

    public List<Trening> getTrenings() {
        return trenings;
    }

    public void setTrenings(List<Trening> trenings) {
        this.trenings = trenings;
    }

    public Set<TerminskaLista> getTerminskaListas() {
        return terminskaListas;
    }

    public void setTerminskaListas(Set<TerminskaLista> terminskaListas) {
        this.terminskaListas = terminskaListas;
    }

    /*----------------------------------------------------------------------*/

    public Sala(Long id, Integer kapacitet, Integer oznakaSale, FitnessCentar fitnessCentar, TerminskaLista trening, List<Trening> trenings, Set<TerminskaLista> terminskaListas) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
        this.fitnessCentar = fitnessCentar;
        this.trening = trening;
        this.trenings = trenings;
        this.terminskaListas = terminskaListas;
    }

    public Sala() {
    }

    public Sala(Long id, Integer kapacitet, Integer oznakaSale) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
    }



    /*
    public static Sala getSalaByDTO(SalaDTO salaDTO) {
        Sala sala=new Sala();
        sala.setKapacitet(salaDTO.getKapacitet());
        sala.setOznakaSale(salaDTO.getOznakaSale());
        return sala;
    }*/


}
