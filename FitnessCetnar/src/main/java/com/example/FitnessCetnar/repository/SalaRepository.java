package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Position;
import com.example.FitnessCetnar.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala,Long> {
    @Query("update Sala set kapacitet = :kapacitet, oznakaSale=:oznakaSale WHERE id = :Id")
    void updateSala(@Param("Id") Long id,@Param("kapacitet") Integer kapacitet,@Param("oznakaSale") Integer oznakaSale);
}
