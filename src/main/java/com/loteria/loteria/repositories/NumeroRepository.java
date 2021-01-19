package com.loteria.loteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loteria.loteria.entidades.Numero;

@Repository
public interface NumeroRepository extends JpaRepository<Numero, Integer>{

}
