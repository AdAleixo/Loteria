package com.loteria.loteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loteria.loteria.entidades.Apostador;

@Repository
public interface ApostadorRepository extends JpaRepository<Apostador, String> {

}
