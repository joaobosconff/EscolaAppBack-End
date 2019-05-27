package br.facisa.pp.Escola.api.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.facisa.pp.Escola.api.domains.dtos.AlunoCreateDto;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private Integer idade;
	private String endereco;

	private int serie;

	@OneToMany
	private List<Nota> notas;

	public Aluno() {
	}

	public Aluno(String nome, Integer idade, String endereco, int serie, List<Nota> notas) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.serie = serie;
		this.notas = notas;
	}
	
	public Aluno(AlunoCreateDto dto) {
		this.nome = dto.getNome();
		this.idade = dto.getIdade();
		this.endereco = dto.getEndereco();
		this.serie = dto.getSerie();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

}