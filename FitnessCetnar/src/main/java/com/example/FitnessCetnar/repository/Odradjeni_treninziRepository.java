package com.example.FitnessCetnar.repository;

import com.example.FitnessCetnar.entity.Odradjeni_treninzi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Odradjeni_treninziRepository extends JpaRepository<Odradjeni_treninzi,Long> {
    List<Odradjeni_treninzi> findByTreningId(Long id);
    @Modifying
    @Query("update Odradjeni_treninzi set ocena=:ocena WHERE id=:id")
    void setOcena(@Param("id")Long id,@Param("ocena") Long ocena);
}
