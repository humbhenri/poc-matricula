package com.unibrasil.sca.matricula.inscricao;

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
import javax.validation.constraints.Size;

import com.unibrasil.sca.matricula.aluno.Aluno;
import com.unibrasil.sca.matricula.turma.Turma;

@Entity
@Table(name = "inscricoes")
public class Inscricao{

	public static final int MAX_CREDITOS = 10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(targetEntity=Aluno.class)
	@JoinColumn(name="aluno")
	private Aluno aluno;

	@ManyToMany
	@JoinTable(name = "inscricoes_turmas", joinColumns = @JoinColumn(name = "id_inscricao"), inverseJoinColumns = @JoinColumn(name = "id_turma"))
	@Size(min=1, message="É preciso no mínimo uma turma")
	private Set<Turma> turmas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}

}
