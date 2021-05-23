package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TreningRepository extends JpaRepository<Trening,Long> {
    @Modifying
    @Query("update Trening  set rating = :rating WHERE id = :treningId")
    void setRating(@Param("treningId") Long id,@Param("rating") double rating);
}
