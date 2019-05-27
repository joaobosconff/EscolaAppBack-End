package br.facisa.pp.Escola.api.domains.dtos;

import java.util.List;

public class AlunoCreateDto {
	
	private String nome;
	private Integer idade;
	private String endereco;
	
	private int serie;
	
	private List<Long> idDisciplinas;

	public AlunoCreateDto(String nome, Integer idade, String endereco, int serie, List<Long> idDisciplinas) {
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.serie = serie;
		this.idDisciplinas = idDisciplinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public List<Long> getIdDisciplinas() {
		return idDisciplinas;
	}

	public void setIdDisciplinas(List<Long> idDisciplinas) {
		this.idDisciplinas = idDisciplinas;
	}
	
	

}
