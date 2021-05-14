package com.example.FitnessCetnar.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Trener implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToMany(mappedBy="trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Trening> ListaTreningaKojeDrzi = new ArrayList<>();



    private double prosecnaOcena(){
        double broj = 0;
        double ocena = 0;
        for(int i = 0;i<ListaTreningaKojeDrzi.size();i++){
            ocena += ListaTreningaKojeDrzi.get(i).getId();
        }
        double prosecnaOcena = ocena/ListaTreningaKojeDrzi.size();

        return prosecnaOcena;
    }


    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private Character password;

    @Column(nullable = false,unique = true)
    private Integer telefon;

    @Column(nullable = false)
    private Date datum;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private Boolean aktivan;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Trening> getListaTreningaKojeDrzi() {
        return ListaTreningaKojeDrzi;
    }

    public void setListaTreningaKojeDrzi(List<Trening> listaTreningaKojeDrzi) {
        ListaTreningaKojeDrzi = listaTreningaKojeDrzi;
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

    public String getPozicija() {
        return position;
    }

    public void setPozicija(String position) {
        this.position = position;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }

    @Override
    public String toString() {
        return "Trener{" +
                "id=" + id +
                ", ListaTreningaKojeDrzi=" + ListaTreningaKojeDrzi +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", telefon=" + telefon +
                ", datum=" + datum +
                ", pozicija='" + position + '\'' +
                ", aktivan=" + aktivan +
                ", fitnessCentar=" + fitnessCentar +
                '}';
    }
}
