package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalaRepository extends JpaRepository<Sala,Long> {
    @Modifying
    @Query("update Sala set oznakaSale=:oznakaSale,kapacitet=:kapacitet WHERE id=:Id")
    void updateSala(@Param("Id")Long id,@Param("oznakaSale")Integer oznakaSale,@Param("kapacitet")Integer kapacitet);
}
