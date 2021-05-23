package com.example.FitnessCetnar.service;

import com.example.FitnessCetnar.entity.Trening;
import com.example.FitnessCetnar.entity.dto.TreningDTO;
import com.example.FitnessCetnar.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreningService {

    @Autowired
    private TreningRepository treningRepository;

    public Trening findOne(Long id){
       Trening trening = this.treningRepository.findById(id).get();
       return trening;
    }
    public List<Trening> findAll(){
        List<Trening> treningList = this.treningRepository.findAll();
        return treningList;
    }

    public Trening save(Trening trening) {return  this.treningRepository.save(trening);}

    public TreningDTO getPodaci(){
        List<Trening> trenings = findAll();
        List<String> tip = new ArrayList<String>();
        for(int i = 0;i<trenings.size();i++){
            if(!tip.contains(trenings.get(i).getTipTreninga())){
                tip.add(trenings.get(i).getTipTreninga());
            }
        }
        return new TreningDTO(trenings,tip);
    }

}
