package com.example.FitnessCetnar.entity.dto;

public class PrijavaDTO {
    private Long korisnik_id;

    private Long terminskaLista_id;

    public Long getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(Long korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public Long getTerminskaLista_id() {
        return terminskaLista_id;
    }

    public void setTerminskaLista_id(Long terminskaLista_id) {
        this.terminskaLista_id = terminskaLista_id;
    }

    public PrijavaDTO(Long korisnik_id, Long terminskaLista_id) {
        super();
        this.korisnik_id = korisnik_id;
        this.terminskaLista_id = terminskaLista_id;
    }

    public PrijavaDTO() {
    }
}
