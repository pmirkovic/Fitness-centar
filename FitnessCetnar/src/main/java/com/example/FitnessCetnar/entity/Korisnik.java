
package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*----------------------------------------------------------------------*/


    /*Kolone*/
    @Column
    private String username;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column(unique = true)
    private Integer telefon;


    @Column
    private Date datum;

    @Column
    private Position position;


    @Column
    private Boolean aktivan;

    /*----------------------------------------------------------------------*/

    public Korisnik() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;




    @OneToMany(mappedBy="korisnik",fetch=FetchType.EAGER,orphanRemoval=true)
    Set<Odradjeni_treninzi> odradjeni_treninzis=new HashSet<>();

    public Korisnik(String naziv, String adresa, String email, Integer brTelefona) {

    }

    public Korisnik(String ime, String prezime, Position position, String username, String email, Integer telefon, Date datum, Boolean aktivan, String password) {
    }

    public Set<Odradjeni_treninzi> getOdradjeni_treninzis() {
        return odradjeni_treninzis;
    }

    public void setOdradjeni_treninzis(Set<Odradjeni_treninzi> odradjeni_treninzis) {
        this.odradjeni_treninzis = odradjeni_treninzis;
    }


    /*----------------------------------------------------------------------*/

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public Date getDatum() {
        return datum;
    }

    public Position getPosition() {
        return position;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }




    /*----------------------------------------------------------------------*/

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }




    public Korisnik(Set<Odradjeni_treninzi> odradjeni_treninzis) {
        this.odradjeni_treninzis = odradjeni_treninzis;
    }

    /*----------------------------------------------------------------------*/
    public Korisnik(String ime, String prezime, Boolean aktivan, Date datum, Character password, String email, Integer telefon, Position position, String username, FitnessCentar fitnessCentar){}

    public Korisnik(String ime, String prezime, Position position, Date datum, Boolean aktivan, String username, Integer telefon, String email, String password){}

    public Korisnik(long id, String username, String ime, String prezime, String email, String password, Integer telefon, Date datum, Position position, Boolean aktivan, FitnessCentar fitnessCentar, Set<Trener> treners,  Set<Odradjeni_treninzi> odradjeni_treninzis) {
        this.id = id;
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.telefon = telefon;
        this.datum = datum;
        this.position = position;
        this.aktivan = aktivan;
        this.fitnessCentar = fitnessCentar;


    }
/*
    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telefon=" + telefon +
                ", datum=" + datum +
                ", position=" + position +
                ", aktivan=" + aktivan +
                ", fitnessCentar=" + fitnessCentar +
                '}';
    }
 */
}

