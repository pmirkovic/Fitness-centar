package com.example.FitnessCetnar.entity.dto;

public class SalaDTO {
    private Long id;
    private Integer kapacitet;
    private Integer oznakaSale;
    private Long fitness_centar_id;

    public SalaDTO(Long id, Integer kapacitet, Integer oznakaSale) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
    }

    public SalaDTO() {

    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public Integer getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(Integer oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public Long getFitness_centar_id() {
        return fitness_centar_id;
    }

    public void setFitness_centar_id(Long fitness_centar_id) {
        this.fitness_centar_id = fitness_centar_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
