
package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;


@Entity
@Table(name = "korisnik_teretane")

@Inheritance(strategy = SINGLE_TABLE)

@DiscriminatorColumn(name = "type",discriminatorType = STRING)

public abstract class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*----------------------------------------------------------------------*/

    public Korisnik() {
    }
    /*----------------------------------------------------------------------*/


    /*Kolone*/
    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "ime",nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private Character password;

    @Column(name = "telefon", nullable = false,unique = true)
    private Integer telefon;

    @Column(name = "datum", nullable = false)
    private Date datum;

    @Column(name = "pozicija", nullable = false)
    private String position;

    @Column(name = "aktivan", nullable = false)
    private Boolean aktivan;

    /*----------------------------------------------------------------------*/

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

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

    public String getPosition() {
        return position;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
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

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }

    /*----------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", telefon=" + telefon +
                ", datum=" + datum +
                ", position='" + position + '\'' +
                ", aktivan=" + aktivan +
                ", fitnessCentar=" + fitnessCentar +
                '}';
    }
}

