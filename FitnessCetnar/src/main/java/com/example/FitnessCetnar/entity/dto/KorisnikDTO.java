package com.example.FitnessCetnar.entity.dto;

import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Position;

import javax.persistence.Column;
import java.util.Date;

public class KorisnikDTO {

    /*private Long id;
    private String email;
    private String password;

    public KorisnikDTO(){}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    private Long id;
    private String ime;
    private String prezime;
    private Position position;
    private String username;
    private String email;
    private Integer telefon;
    private Date datum;
    private Boolean aktivan;
    private String password;

    public KorisnikDTO(){}

    public KorisnikDTO(Long id, String ime, String prezime, Position position, String username, String email, Integer telefon, Date datum, Boolean aktivan, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.position = position;
        this.username = username;
        this.email = email;
        this.telefon = telefon;
        this.datum = datum;
        this.aktivan = aktivan;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
