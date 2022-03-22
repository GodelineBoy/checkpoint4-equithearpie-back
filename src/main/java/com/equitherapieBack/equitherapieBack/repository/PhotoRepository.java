package com.equitherapieBack.equitherapieBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.equitherapieBack.equitherapieBack.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository <Photo, Long>{

}
