package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.FitnessCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnesCentarRepository extends JpaRepository<FitnessCentar,Long> {
    @Modifying
    @Query("update FitnessCentar set naziv = :naziv WHERE id = :id")
    void updateFitnesCentar(@Param("Id") Long id,@Param("naziv") String naziv);

    //void updateFitnesCentar(Long );
}
