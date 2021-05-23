package com.example.FitnessCetnar.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("administrator")
public class Administrator extends Korisnik{
}
