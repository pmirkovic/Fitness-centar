package com.example.FitnessCetnar.entity.dto;

public class TerminskaListaDTO {
    private Long id;
    private String dan;


    public TerminskaListaDTO() {
    }

    public TerminskaListaDTO(Long id,String dan) {
        this.id = id;
        this.dan = dan;

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

}
