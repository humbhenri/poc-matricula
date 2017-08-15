/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibrasil.sca.matricula.professor;

import com.unibrasil.sca.matricula.turma.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author humbhenri
 */
@RestController
public class ProfessorInfoController {
    
    @Autowired
    private ProfessorInfoRepository repo;
    
    @GetMapping("/professor/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Integer id) {
        final Professor professor = repo.findOne(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professor);
    }
}
