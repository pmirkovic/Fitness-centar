
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

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "Prijava",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    Set<Trening> prijava_treninga=new HashSet<>();

    @OneToMany(mappedBy = "korisnik",fetch = FetchType.EAGER,orphanRemoval = true)
    Set<Trener> treners=new HashSet<>();
    @OneToMany(mappedBy = "korisnik",fetch = FetchType.EAGER,orphanRemoval = true)
    Set<ClanFitnesCentra> clanFitnesCentras=new HashSet<>();
    @OneToMany(mappedBy="korisnik",fetch=FetchType.EAGER,orphanRemoval=true)
    Set<Odradjeni_treninzi> odradjeni_treninzis=new HashSet<>();


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

    public Set<Trener> getTreners() {
        return treners;
    }

    public Set<ClanFitnesCentra> getClanFitnesCentras() {
        return clanFitnesCentras;
    }

    public Set<Odradjeni_treninzi> getOdradjeni_treninzis() {
        return odradjeni_treninzis;
    }

    public Set<Trening> getPrijava_treninga() {
        return prijava_treninga;
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

    public void setTreners(Set<Trener> treners) {
        this.treners = treners;
    }

    public void setClanFitnesCentras(Set<ClanFitnesCentra> clanFitnesCentras) {
        this.clanFitnesCentras = clanFitnesCentras;
    }

    public void setOdradjeni_treninzis(Set<Odradjeni_treninzi> odradjeni_treninzis) {
        this.odradjeni_treninzis = odradjeni_treninzis;
    }

    public void setPrijava_treninga(Set<Trening> prijava_treninga) {
        this.prijava_treninga = prijava_treninga;
    }

    /*----------------------------------------------------------------------*/
    public Korisnik(){}

    public Korisnik(String ime, String prezime, Position position, Date datum, Boolean aktivan, String username, Integer telefon, String email, String password){}

    public Korisnik(long id, String username, String ime, String prezime, String email, String password, Integer telefon, Date datum, Position position, Boolean aktivan, FitnessCentar fitnessCentar, Set<Trening> prijava_treninga, Set<Trener> treners, Set<ClanFitnesCentra> clanFitnesCentras, Set<Odradjeni_treninzi> odradjeni_treninzis) {
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
        this.prijava_treninga = prijava_treninga;
        this.treners = treners;
        this.clanFitnesCentras = clanFitnesCentras;
        this.odradjeni_treninzis = odradjeni_treninzis;
    }

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
                ", prijava_treninga=" + prijava_treninga +
                ", treners=" + treners +
                ", clanFitnesCentras=" + clanFitnesCentras +
                ", odradjeni_treninzis=" + odradjeni_treninzis +
                '}';
    }
}

