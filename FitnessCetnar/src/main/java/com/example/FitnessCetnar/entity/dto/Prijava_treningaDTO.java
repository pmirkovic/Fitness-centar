package com.example.FitnessCetnar.entity.dto;

public class Prijava_treningaDTO {
    private Long korisnik_id;
    private Long trening_id;

    public Prijava_treningaDTO(){}

    public Long getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(Long korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public Long getTrening_id() {
        return trening_id;
    }

    public void setTrening_id(Long trening_id) {
        this.trening_id = trening_id;
    }
}
