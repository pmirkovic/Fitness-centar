package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ClanFitnesCentra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name = "Lista_odradjenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Trening_id", referencedColumnName = "id"))
    private List<Trening> ListaOdradjenihTreninga = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Lista_Prijavljenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Trening_id", referencedColumnName = "id"))
    private List<Trening> ListaPrijavljenihTreninga = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Ocena_Odradjenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Trening_id", referencedColumnName = "id"))
    private List<Trening> OcenaOdradjenihTreninga = new ArrayList<>();

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
    private String position;

    @Column(nullable = false)
    private Boolean aktivan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Trening> getListaOdradjenihTreninga() {
        return ListaOdradjenihTreninga;
    }

    public void setListaOdradjenihTreninga(List<Trening> listaOdradjenihTreninga) {
        ListaOdradjenihTreninga = listaOdradjenihTreninga;
    }

    public List<Trening> getListaPrijavljenihTreninga() {
        return ListaPrijavljenihTreninga;
    }

    public void setListaPrijavljenihTreninga(List<Trening> listaPrijavljenihTreninga) {
        ListaPrijavljenihTreninga = listaPrijavljenihTreninga;
    }

    public List<Trening> getOcenaOdradjenihTreninga() {
        return OcenaOdradjenihTreninga;
    }

    public void setOcenaOdradjenihTreninga(List<Trening> ocenaOdradjenihTreninga) {
        OcenaOdradjenihTreninga = ocenaOdradjenihTreninga;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getPassword() {
        return password;
    }

    public void setPassword(Character password) {
        this.password = password;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getPozicija() {
        return position;
    }

    public void setPozicija(String position) {
        this.position = position;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    @Override
    public String toString() {
        return "ClanFitnesCentra{" +
                "id=" + id +
                ", ListaOdradjenihTreninga=" + ListaOdradjenihTreninga +
                ", ListaPrijavljenihTreninga=" + ListaPrijavljenihTreninga +
                ", OcenaOdradjenihTreninga=" + OcenaOdradjenihTreninga +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", telefon=" + telefon +
                ", datum=" + datum +
                ", pozicija='" + position + '\'' +
                ", aktivan=" + aktivan +
                '}';
    }
}
