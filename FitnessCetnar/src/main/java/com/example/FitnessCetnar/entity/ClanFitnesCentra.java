/*package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity

public class ClanFitnesCentra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Korisnik korisnik;

    @JsonIgnore
    @Column
    @ManyToMany
    @JoinTable(name = "Lista_odradjenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Termin_id", referencedColumnName = "id"))
    private List<Trening> ListaOdradjenihTreninga = new ArrayList<>();

    @JsonIgnore
    @Column
    @ManyToMany
    @JoinTable(name = "Lista_Prijavljenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Termin_id", referencedColumnName = "id"))
    private List<Trening> ListaPrijavljenihTreninga = new ArrayList<>();

    @JsonIgnore
    @Column
    @ManyToMany
    @JoinTable(name = "Ocena_Odradjenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Termin_id", referencedColumnName = "id"))
    private List<Trening> OcenaOdradjenihTreninga = new ArrayList<>();

    public ClanFitnesCentra() {
    }



    public Long getId() {
        return id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public List<Trening> getListaOdradjenihTreninga() {
        return ListaOdradjenihTreninga;
    }

    public List<Trening> getListaPrijavljenihTreninga() {
        return ListaPrijavljenihTreninga;
    }

    public List<Trening> getOcenaOdradjenihTreninga() {
        return OcenaOdradjenihTreninga;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public void setListaOdradjenihTreninga(List<Trening> listaOdradjenihTreninga) {
        ListaOdradjenihTreninga = listaOdradjenihTreninga;
    }

    public void setListaPrijavljenihTreninga(List<Trening> listaPrijavljenihTreninga) {
        ListaPrijavljenihTreninga = listaPrijavljenihTreninga;
    }

    public void setOcenaOdradjenihTreninga(List<Trening> ocenaOdradjenihTreninga) {
        OcenaOdradjenihTreninga = ocenaOdradjenihTreninga;
    }



    public ClanFitnesCentra(Long id, Korisnik korisnik, List<Trening> listaOdradjenihTreninga, List<Trening> listaPrijavljenihTreninga, List<Trening> ocenaOdradjenihTreninga) {
        this.id = id;
        this.korisnik = korisnik;
        ListaOdradjenihTreninga = listaOdradjenihTreninga;
        ListaPrijavljenihTreninga = listaPrijavljenihTreninga;
        OcenaOdradjenihTreninga = ocenaOdradjenihTreninga;
    }

    @Override
    public String toString() {
        return "ClanFitnesCentra{" +
                "id=" + id +
                ", korisnik=" + korisnik +
                ", ListaOdradjenihTreninga=" + ListaOdradjenihTreninga +
                ", ListaPrijavljenihTreninga=" + ListaPrijavljenihTreninga +
                ", OcenaOdradjenihTreninga=" + OcenaOdradjenihTreninga +
                '}';
    }
}
*/