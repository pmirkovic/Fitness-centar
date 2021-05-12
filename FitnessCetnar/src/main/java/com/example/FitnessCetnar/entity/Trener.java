package com.example.FitnessCetnar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trener implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private List<Trening> ListaTreningaKojeDrzi = new ArrayList<>();

    private double prosecnaOcena(){
        double broj = 0;
        double ocena = 0;
        for(int i = 0;i<ListaTreningaKojeDrzi.size();i++){
            ocena += ListaTreningaKojeDrzi.get(i).getId();
        }
        double prosecnaOcena = ocena/ListaTreningaKojeDrzi.size();

        return prosecnaOcena;

    }



}
