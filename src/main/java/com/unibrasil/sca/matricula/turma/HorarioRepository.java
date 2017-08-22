package com.unibrasil.sca.matricula.turma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unibrasil.sca.Horario;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Integer>{

}
