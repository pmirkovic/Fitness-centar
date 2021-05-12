package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Integer kapacitet;

    @Column
    private Integer oznakaSale;

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", kapacitet=" + kapacitet +
                ", oznakaSale=" + oznakaSale +
                '}';
    }
}
