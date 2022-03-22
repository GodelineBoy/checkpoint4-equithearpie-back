package com.equitherapieBack.equitherapieBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equitherapieBack.equitherapieBack.entity.Tarif;

@Repository
public interface TarifRepository extends JpaRepository <Tarif, Long>{

}
