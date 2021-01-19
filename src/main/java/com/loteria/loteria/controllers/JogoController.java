package com.loteria.loteria.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loteria.loteria.entidades.Apostador;
import com.loteria.loteria.entidades.Jogo;
import com.loteria.loteria.entidades.JogoDTO;
import com.loteria.loteria.entidades.Numero;
import com.loteria.loteria.repositories.ApostadorRepository;
import com.loteria.loteria.repositories.JogoRepository;
import com.loteria.loteria.repositories.NumeroRepository;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

	@Autowired
	private ApostadorRepository apostadorRepository;

	@Autowired
	private JogoRepository jogoRepository;

	@Autowired
	private NumeroRepository numeroRepository;

	@PostMapping
	public Jogo criarJogo(@RequestParam String email) {

		Optional<Apostador> apostadorOptional = apostadorRepository.findById(email);

		if (!apostadorOptional.isPresent()) {

			Apostador apostador = new Apostador();
			apostador.setEmail(email);
			apostadorRepository.save(apostador);

			apostadorOptional = Optional.of(apostador);

		}

		Jogo jogo = new Jogo();

		jogo.setApostador(apostadorOptional.get());
		jogoRepository.save(jogo);

		for (int i = 0; i < 6; i++) {

			Numero numero = new Numero();
			int rand = (int) ((double)60*Math.random());
			rand+= 1;
			numero.setNumero(rand);
			numero.setJogo(jogo);
			numeroRepository.save(numero);

		}

		return jogo;

	}

	@GetMapping
	public List<JogoDTO> recuperarJogo(@RequestParam String email) {

		Optional<Apostador> apostadorOptional = apostadorRepository.findById(email);

		List<Jogo> jogos = jogoRepository.findByApostadorEmail(email);
		List<JogoDTO> jogosDTO = new ArrayList<>();

		for (Jogo jogo : jogos) {

			JogoDTO jogoDTO = new JogoDTO();

			jogoDTO.setEmail(jogo.getApostador().getEmail());
			jogoDTO.setIdJogo(jogo.getId());

			for (Numero numero : jogo.getNumeros()) {

				jogoDTO.getNumeros().add(numero.getNumero());
			}

			jogosDTO.add(jogoDTO);
		}
		return jogosDTO;
	}

}
