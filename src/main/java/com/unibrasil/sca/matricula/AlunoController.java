package com.unibrasil.sca.matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoRepository repo;

	@RequestMapping("/alunos/{username}")
	Aluno findByUsername(@PathVariable String username) {
		return this.repo.findByUsername(username);
	}
}
