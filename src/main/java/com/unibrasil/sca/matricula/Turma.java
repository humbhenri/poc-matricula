package com.unibrasil.sca.matricula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="turmas")
public class Turma {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Disciplina disciplina;
	private int capacidade;
	private int semestre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	
}
