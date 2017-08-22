package com.unibrasil.sca.matricula.turma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unibrasil.sca.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer>{

}
