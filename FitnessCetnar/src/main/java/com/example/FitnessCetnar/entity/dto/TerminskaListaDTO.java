package com.example.FitnessCetnar.entity.dto;

import javax.persistence.Column;

public class TerminskaListaDTO {
    private Long id;

    private String dan;


    private Double cena;


    private Integer brojClanova;

    public TerminskaListaDTO() {
    }

    public TerminskaListaDTO(Long id, String dan, Double cena, Integer brojClanova) {
        this.id = id;
        this.dan = dan;
        this.cena = cena;
        this.brojClanova = brojClanova;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getBrojClanova() {
        return brojClanova;
    }

    public void setBrojClanova(Integer brojClanova) {
        this.brojClanova = brojClanova;
    }
}
