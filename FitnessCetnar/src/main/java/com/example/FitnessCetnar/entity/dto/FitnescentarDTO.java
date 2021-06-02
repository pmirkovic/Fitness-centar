package com.example.FitnessCetnar.entity.dto;

import javax.persistence.Column;

public class FitnescentarDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private Integer brTelefona;
    private String email;

    public FitnescentarDTO(Long id, String naziv, String adresa, String email, Integer brTelefona) {
    }

    public FitnescentarDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(Integer brTelefona) {
        this.brTelefona = brTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
