package com.example.FitnessCetnar.service.impl;

import com.example.FitnessCetnar.entity.Korisnik;
import com.example.FitnessCetnar.entity.Trening;
import com.example.FitnessCetnar.repository.KorisnikRepository;
import com.example.FitnessCetnar.repository.TreningRepository;
import com.example.FitnessCetnar.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TreningServiceImpl implements TreningService {

    private  final TreningRepository treningRepository;


    public TreningServiceImpl(TreningRepository treningRepository){this.treningRepository=treningRepository;}

    @Override
    public Trening findOne(Long id){
        Trening trening = this.treningRepository.getOne(id);
        return trening;
    }

    @Override
    public List<Trening> findAll() {
        List<Trening> trenings = this.treningRepository.findAll();
        return trenings;
    }

    @Override
    public Trening create(Trening trening)throws Exception{
        if(trening.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Trening newTrening = this.treningRepository.save(trening);
        return newTrening;
    }

    @Override
    public Trening update(Trening trening) throws Exception{
        Trening treningToUpdate = this.treningRepository.getOne(trening.getId());
        if(treningToUpdate == null){
            throw new Exception("Trening doesn't exist!");
        }
        treningToUpdate.setCena(trening.getCena());

        Trening savedT = this.treningRepository.save(treningToUpdate);
        return savedT;
    }

    @Override
    public void delete(Long id){this.treningRepository.deleteById(id);}
}
