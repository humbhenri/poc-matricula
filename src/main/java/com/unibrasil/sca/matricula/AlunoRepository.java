package com.unibrasil.sca.matricula;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
	
	Aluno findByUsername(String username);
}
