package com.unibrasil.sca.matricula.disciplina;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends PagingAndSortingRepository<Disciplina, String> {

}
