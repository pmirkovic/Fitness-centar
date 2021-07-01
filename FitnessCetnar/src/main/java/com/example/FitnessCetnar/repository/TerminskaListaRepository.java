package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.TerminskaLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminskaListaRepository extends JpaRepository<TerminskaLista, Long> {
    List<TerminskaLista> findByTreningId(Long id);
}
