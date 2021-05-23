package com.example.FitnessCetnar.entity.dto;

import com.example.FitnessCetnar.entity.Korisnik;

public class KorisnikDTO {

    private String email;
    private String password;

    public KorisnikDTO(){}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
