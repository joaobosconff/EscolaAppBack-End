package br.facisa.pp.Escola.api.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<Aluno> alunos;
	
	@OneToOne
	private Professor professor;

	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public Long getId() {
		return id;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Turma(List<Aluno> alunos, Professor professor) {
		this.alunos = alunos;
		this.professor = professor;
	}
	
	
	
	

}
