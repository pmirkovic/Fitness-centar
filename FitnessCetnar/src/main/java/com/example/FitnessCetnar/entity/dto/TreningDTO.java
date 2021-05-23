package com.example.FitnessCetnar.entity.dto;

import com.example.FitnessCetnar.entity.Trening;

import java.util.List;

public class TreningDTO {
    private List<Trening> treningList;
    private List<String> tipTreninga;

    public List<Trening> getTreningList() {
        return treningList;
    }

    public void setTreningList(List<Trening> treningList) {
        this.treningList = treningList;
    }

    public List<String> getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(List<String> tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public TreningDTO(List<Trening> treningList, List<String> tipTreninga) {
        this.treningList = treningList;
        this.tipTreninga = tipTreninga;
    }
}
