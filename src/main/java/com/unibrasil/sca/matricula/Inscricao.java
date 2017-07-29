package com.unibrasil.sca.matricula;

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

@Entity
@Table(name = "inscricoes")
public class Inscricao{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(targetEntity=Aluno.class)
	@JoinColumn(name="aluno")
	private Aluno aluno;

	@ManyToMany
	@JoinTable(name = "inscricoes_disciplinas", joinColumns = @JoinColumn(name = "id_inscricao"), inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
	private Set<Disciplina> disciplinas;

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

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
