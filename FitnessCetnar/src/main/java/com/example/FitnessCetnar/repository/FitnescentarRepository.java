package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.FitnessCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnescentarRepository extends JpaRepository<FitnessCentar,Long> {

}
