package com.unibrasil.sca.matricula.disciplina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisciplinaController {

	@Autowired
	DisciplinaRepository repo;
	
	@RequestMapping("/disciplinas")
	public Iterable<Disciplina> getAll() {
		return repo.findAll();
	}
}
