package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("ClanFitnesCentra")
public class ClanFitnesCentra extends Korisnik{

    @Column
    @ManyToMany
    @JoinTable(name = "Lista_odradjenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Termin_id", referencedColumnName = "id"))
    private List<Trening> ListaOdradjenihTreninga = new ArrayList<>();
    @Column
    @ManyToMany
    @JoinTable(name = "Lista_Prijavljenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Termin_id", referencedColumnName = "id"))
    private List<Trening> ListaPrijavljenihTreninga = new ArrayList<>();
    @Column
    @ManyToMany
    @JoinTable(name = "Ocena_Odradjenih_treninga",
            joinColumns = @JoinColumn(name = "Clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Termin_id", referencedColumnName = "id"))
    private List<Trening> OcenaOdradjenihTreninga = new ArrayList<>();

    public ClanFitnesCentra() {
    }

    /*----------------------------------------------------------------------*/

    public List<Trening> getListaOdradjenihTreninga() {
        return ListaOdradjenihTreninga;
    }

    public List<Trening> getListaPrijavljenihTreninga() {
        return ListaPrijavljenihTreninga;
    }

    public List<Trening> getOcenaOdradjenihTreninga() {
        return OcenaOdradjenihTreninga;
    }
    /*----------------------------------------------------------------------*/

    public void setListaOdradjenihTreninga(List<Trening> listaOdradjenihTreninga) {
        ListaOdradjenihTreninga = listaOdradjenihTreninga;
    }

    public void setListaPrijavljenihTreninga(List<Trening> listaPrijavljenihTreninga) {
        ListaPrijavljenihTreninga = listaPrijavljenihTreninga;
    }

    public void setOcenaOdradjenihTreninga(List<Trening> ocenaOdradjenihTreninga) {
        OcenaOdradjenihTreninga = ocenaOdradjenihTreninga;
    }

    /*----------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "ClanFitnesCentra{" +
                "ListaOdradjenihTreninga=" + ListaOdradjenihTreninga +
                ", ListaPrijavljenihTreninga=" + ListaPrijavljenihTreninga +
                ", OcenaOdradjenihTreninga=" + OcenaOdradjenihTreninga +
                '}';
    }
}
