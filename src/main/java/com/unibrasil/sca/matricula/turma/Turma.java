package com.unibrasil.sca.matricula.turma;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.unibrasil.sca.matricula.disciplina.Disciplina;

@Entity
@Table(name="turmas")
public class Turma {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="disciplina")
	private Disciplina disciplina;
	
	private int capacidade;
	
	private int semestre;
	
	@ManyToOne
	@JoinColumn(name="professor")
	private Professor professor;
	
	@ManyToMany
	@JoinTable(name="horarios_turmas", 
    joinColumns=@JoinColumn(name="turma_id"),
    inverseJoinColumns=@JoinColumn(name="horario_id"))
	private Set<Horario> horarios;
	
	
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
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Set<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}
	
}
