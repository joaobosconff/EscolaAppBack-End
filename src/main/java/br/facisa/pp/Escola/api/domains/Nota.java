package br.facisa.pp.Escola.api.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private double nota1;
	
	private double nota2;
	
	private double nota3;
	
	private double media;
	
	@OneToOne
	private Disciplina disciplina;

	public Nota(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public Nota() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getNota1() {
		return nota1;
	}


	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}


	public double getNota2() {
		return nota2;
	}


	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}


	public double getNota3() {
		return nota3;
	}


	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}


	public double getMedia() {
		return media;
	}


	public void setMedia(double media) {
		this.media = media;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}
