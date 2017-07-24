package com.unibrasil.sca.matricula;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="disciplinas")
public class Disciplina {

	@Id
	private String id;
	
	@ManyToMany
	@JoinTable(name="disciplinas_requisitos", 
    joinColumns=@JoinColumn(name="id_disciplina"),
    inverseJoinColumns=@JoinColumn(name="id_requisito"))
	private Set<Disciplina> requisitos = null;
	
	private String nome;
	
	private Integer creditos;
	
	private Integer aulas;
	
	private Integer laboratorios;
	
	private Integer estagios;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Disciplina> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(Set<Disciplina> requisitos) {
		this.requisitos = requisitos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getAulas() {
		return aulas;
	}

	public void setAulas(Integer aulas) {
		this.aulas = aulas;
	}

	public Integer getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(Integer laboratorios) {
		this.laboratorios = laboratorios;
	}

	public Integer getEstasgios() {
		return estagios;
	}

	public void setEstagios(Integer estagio) {
		this.estagios = estagio;
	}

}