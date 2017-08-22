package com.unibrasil.sca.matricula.aluno;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unibrasil.sca.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
	
	Aluno findByUsername(String username);
}
