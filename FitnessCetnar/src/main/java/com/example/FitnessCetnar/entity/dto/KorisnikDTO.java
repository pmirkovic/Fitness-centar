package com.example.FitnessCetnar.entity.dto;

import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Position;

public class KorisnikDTO {

    private Long id;
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
    }
/*
    private Long id;
    private String ime;
    private String prezime;
    private Position position;

    public KorisnikDTO(long id, String ime, String prezime, Position position) {
    }

    public KorisnikDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return ime;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }*/
}
