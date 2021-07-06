package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Prijava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long> {
}
