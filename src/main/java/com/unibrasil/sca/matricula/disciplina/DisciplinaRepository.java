package com.unibrasil.sca.matricula.disciplina;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.unibrasil.sca.Disciplina;

@Repository
public interface DisciplinaRepository extends PagingAndSortingRepository<Disciplina, String> {

}
