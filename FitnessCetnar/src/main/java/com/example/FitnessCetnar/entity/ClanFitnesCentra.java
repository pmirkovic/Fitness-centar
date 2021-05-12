package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClanFitnesCentra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    private List<Trening> ListaOdradjenihTreninga = new ArrayList<>();
    private List<Trening> ListaPrijavljenihTreninga = new ArrayList<>();
    private List<Trening> OcenaOdradjenihTreninga = new ArrayList<>();


}
