
package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*----------------------------------------------------------------------*/


    /*Kolone*/
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String ime;

    @Column( nullable = false)
    private String prezime;

    @Column(nullable = false,unique = true)
    private String email;

    @Column( nullable = false)
    private Character password;

    @Column(nullable = false,unique = true)
    private Integer telefon;

    @Column( nullable = false)
    private Date datum;

    @Column( nullable = false)
    private Position position;

    @Column( nullable = false)
    private Boolean aktivan;

    /*----------------------------------------------------------------------*/

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    @OneToMany(mappedBy = "korisnik",fetch = FetchType.EAGER,orphanRemoval = true)
    Set<Trener> treners=new HashSet<>();
    @OneToMany(mappedBy = "korisnik",fetch = FetchType.EAGER,orphanRemoval = true)
    Set<ClanFitnesCentra> clanFitnesCentras=new HashSet<>();

    /*----------------------------------------------------------------------*/

    public long getId() {
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

    public Character getPassword() {
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

    public Set<Trener> getTreners() {
        return treners;
    }

    public Set<ClanFitnesCentra> getClanFitnesCentras() {
        return clanFitnesCentras;
    }

    /*----------------------------------------------------------------------*/

    public void setId(long id) {
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

    public void setPassword(Character password) {
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

    public void setTreners(Set<Trener> treners) {
        this.treners = treners;
    }

    public void setClanFitnesCentras(Set<ClanFitnesCentra> clanFitnesCentras) {
        this.clanFitnesCentras = clanFitnesCentras;
    }

    /*----------------------------------------------------------------------*/

    public Korisnik() {
    }
}

