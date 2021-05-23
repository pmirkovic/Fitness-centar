package com.example.FitnessCetnar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity

public class Administrator implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
