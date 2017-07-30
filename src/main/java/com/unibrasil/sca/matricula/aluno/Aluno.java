package com.unibrasil.sca.matricula.aluno;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.unibrasil.sca.matricula.disciplina.Disciplina;

@Entity
@Table(name="alunos")
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String username;

	@ManyToMany
	@JoinTable(name="alunos_disciplinas", 
    joinColumns=@JoinColumn(name="id_aluno"),
    inverseJoinColumns=@JoinColumn(name="id_disciplina"))
	private Set<Disciplina> disciplinasFeitas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Disciplina> getDisciplinasFeitas() {
		return disciplinasFeitas;
	}

	public void setDisciplinasFeitas(Set<Disciplina> disciplinasFeitas) {
		this.disciplinasFeitas = disciplinasFeitas;
	}
	
	
	
}
