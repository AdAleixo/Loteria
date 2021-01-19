package com.loteria.loteria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loteria.loteria.entidades.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer>{

	List<Jogo> findByApostadorEmail(String email);

}
