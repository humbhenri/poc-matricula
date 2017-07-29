package com.unibrasil.sca.matricula;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface InscricaoRepository extends CrudRepository<Inscricao, Integer>{

//	Collection<Inscricao> getInscricaoAluno(@Param("username") String username);
	
	List<Inscricao> findByAluno_Username(String username);

	void deleteById(int inscricaoId);
}
