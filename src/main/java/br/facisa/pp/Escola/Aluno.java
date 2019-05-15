package br.facisa.pp.Escola;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	private long id;
	
	
	private String nome;
	
	
	private Integer idade;


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public Aluno(long id, String nome, Integer idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}


	

}
