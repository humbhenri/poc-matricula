package com.unibrasil.sca.matricula.inscricao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface InscricaoRepository extends CrudRepository<Inscricao, Integer>{

	List<Inscricao> findByAluno_Username(String username);
	
	Inscricao findFirstByAluno_Username(String username);

}
