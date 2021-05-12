
package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.*;

enum KorisnikVrsta{
    ADNIM,KORISNIK,TRENER
}

@Entity
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private KorisnikVrsta korisnikVrsta;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private Character password;

    @Column(nullable = false,unique = true)
    private Integer telefon;

    @Column(nullable = false)
    private Date datum;

    @Column(nullable = false)
    private String pozicija;

    @Column(nullable = false)
    private Boolean aktivan;

    @ManyToMany
    @JoinTable(name="fitnes",
        joinColumns = @JoinColumn(name = "korisnik_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="trening_id",referencedColumnName = "id"))

    private List<FitnessCentar> trening = new ArrayList<>();


    //GETERI
    public Long getId(){
        return id;
    }
    public void  setId(Long id){
        this.id=id;
    }
    public String getIme(){
        return ime;
    }
    public String getPrezime(){
        return prezime;
    }
    public String getEmail(){
        return email;
    }
    public Character getPassword(){
        return password;
    }
    public Integer getTelefon(){
        return telefon;
    }
    public Date getDatum(){
        return datum;
    }
    public String getPozicija(){
        return pozicija;
    }
    public Boolean getAktivan(){
        return aktivan;
    }
    public KorisnikVrsta getKorisnikVrsta(){
        return korisnikVrsta;
    }

    //SETERI
    public void setKorisnikVrsta(KorisnikVrsta korisnikVrsta){
        this.korisnikVrsta=korisnikVrsta;
    }
    public void setIme(String ime){
        this.ime=ime;
    }
    public void setPrezime(String prezime){
        this.prezime=prezime;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setPassword(Character password){
        this.password=password;
    }
    public void setTelefon(Integer telefon){
        this.telefon=telefon;
    }
    public void setDatum(Date datum){
        this.datum=datum;
    }
    public void setPozicija(String pozicija){
        this.pozicija=pozicija;
    }
    public void setAktivan(Boolean aktivan){
        this.aktivan=aktivan;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", korisnikVrsta=" + korisnikVrsta +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", telefon=" + telefon +
                ", datum=" + datum +
                ", pozicija='" + pozicija + '\'' +
                ", aktivan=" + aktivan +
                ", trening=" + trening +
                '}';
    }
}

