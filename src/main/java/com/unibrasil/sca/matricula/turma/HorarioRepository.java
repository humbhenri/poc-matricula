package com.unibrasil.sca.matricula.turma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Integer>{

}
