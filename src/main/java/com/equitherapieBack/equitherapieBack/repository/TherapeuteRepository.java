package com.equitherapieBack.equitherapieBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equitherapieBack.equitherapieBack.entity.Therapeute;

@Repository
public interface TherapeuteRepository extends JpaRepository <Therapeute, Long>{

}
