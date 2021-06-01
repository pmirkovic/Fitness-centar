package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.Odradjeni_treninzi;
import com.example.FitnessCetnar.repository.Odradjeni_treninziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class Odradjeni_treninziService {
  /*  @Autowired
    private Odradjeni_treninziRepository odradjeni_treninziRepository;

    public Odradjeni_treninzi findOne(Long id){
        Odradjeni_treninzi odradjeni_treninzi=this.odradjeni_treninziRepository.findById(id).get();
        return odradjeni_treninzi;
    }

    public List<Odradjeni_treninzi> findAll(){
        List<Odradjeni_treninzi> odradjeni_treninzis=this.odradjeni_treninziRepository.findAll();
        return odradjeni_treninzis;
    }

    public Odradjeni_treninzi save(Odradjeni_treninzi odradjeni_treninzi){return this.odradjeni_treninziRepository.save(odradjeni_treninzi);}

    public List<Odradjeni_treninzi> getOcenaTreninga(Long id){return this.odradjeni_treninziRepository.findByTreningId(id);}
    public void setOcena(Long id,Long ocena){this.odradjeni_treninziRepository.setOcena(id,ocena);}

    public double averageOcena(Long id){
        List<Odradjeni_treninzi> ocena = this.odradjeni_treninziRepository.findByTreningId(id);

        double avg=0;
        int brojac=0;
        for(int i =0;i<ocena.size();i++){
            if(ocena.get(i).getOcena()==0){
                continue;
            }
            else{
                avg+=ocena.get(i).getOcena();
                brojac++;
            }
        }
        avg=avg/brojac;
        return avg;
    }*/
}
