/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibrasil.sca.matricula.professor;

import com.unibrasil.sca.matricula.turma.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author humbhenri
 */
@Repository
public interface ProfessorInfoRepository extends CrudRepository<Professor, Integer>{
    
}
