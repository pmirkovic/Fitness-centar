package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("trener")
public class Trener extends Korisnik {



    @OneToMany(mappedBy="trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Trening> ListaTreningaKojeDrzi = new ArrayList<>();


    public Trener() {
    }

    /*----------------------------------------------------------------------*/

    public List<Trening> getListaTreningaKojeDrzi() {
        return ListaTreningaKojeDrzi;
    }

    /*----------------------------------------------------------------------*/

    public void setListaTreningaKojeDrzi(List<Trening> listaTreningaKojeDrzi) {
        ListaTreningaKojeDrzi = listaTreningaKojeDrzi;
    }

    /*----------------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Trener{" +
                "ListaTreningaKojeDrzi=" + ListaTreningaKojeDrzi +
                '}';
    }
}
