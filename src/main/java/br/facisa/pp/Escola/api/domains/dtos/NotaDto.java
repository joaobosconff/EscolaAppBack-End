package br.facisa.pp.Escola.api.domains.dtos;

public class NotaDto {
	
	private Integer nota1;
	private Integer nota2;
	private Integer nota3;
	public NotaDto(Integer nota1, Integer nota2, Integer nota3) {
		super();
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	public Integer getNota1() {
		return nota1;
	}
	public void setNota1(Integer nota1) {
		this.nota1 = nota1;
	}
	public Integer getNota2() {
		return nota2;
	}
	public void setNota2(Integer nota2) {
		this.nota2 = nota2;
	}
	public Integer getNota3() {
		return nota3;
	}
	public void setNota3(Integer nota3) {
		this.nota3 = nota3;
	}
	
	

}
