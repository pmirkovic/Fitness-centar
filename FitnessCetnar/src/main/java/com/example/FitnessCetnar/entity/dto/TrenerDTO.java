package com.example.FitnessCetnar.entity.dto;

import com.example.FitnessCetnar.entity.Position;


import java.util.Date;

public class TrenerDTO {
    private Long id;
    private Long fitness_centar_id;
    private String username;
    private String ime;
    private String prezime;
    private String email;
    private Character password;
    private Integer telefon;
    private Date datum;
    private Position position;
    private Boolean aktivan;

    public TrenerDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Long getFitness_centar_id() {
        return fitness_centar_id;
    }

    public void setFitness_centar_id(Long fitness_centar_id) {
        this.fitness_centar_id = fitness_centar_id;
    }
}
