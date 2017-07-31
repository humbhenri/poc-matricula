package com.unibrasil.sca.matricula.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HorarioController {

	@Autowired
	private HorarioRepository repo;
	
	@RequestMapping(path="/horarios")
	Iterable<Horario> findAll() {
		return repo.findAll();
	}

}
