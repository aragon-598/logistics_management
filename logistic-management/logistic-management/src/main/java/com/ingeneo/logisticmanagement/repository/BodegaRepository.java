package com.ingeneo.logisticmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.Bodega;
import com.ingeneo.logisticmanagement.models.TipoBodega;

@Repository 
public interface BodegaRepository extends JpaRepository<Bodega,Integer> {
    List<Bodega> findByTipoBodega(TipoBodega tipoBodega);
}
