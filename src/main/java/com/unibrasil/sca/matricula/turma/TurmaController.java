package com.unibrasil.sca.matricula.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurmaController {

	@Autowired
	private TurmaRepository repo;
	
	@RequestMapping("/turmas")
	public Iterable<Turma> findAll() {
		return repo.findAll();
	}
}
