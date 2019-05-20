package br.facisa.pp.Escola.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.pp.Escola.api.domains.Aluno;
import br.facisa.pp.Escola.api.exceptions.BadRequestException;
import br.facisa.pp.Escola.api.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRep;
	
	public Aluno createAluno(Aluno aluno) {
		return alunoRep.save(aluno);
	}
	public String deleteAluno(Long id) {
		alunoRep.deleteById(id);
		return "deletado";
	}
	public Aluno updateAluno(Long id,Aluno aluno) {
		Aluno alunoTemp = this.getAlunoById(id);
		alunoTemp.setIdade(aluno.getIdade());
		alunoTemp.setNome(aluno.getNome());
		return alunoRep.save(alunoTemp);
	}
	public Aluno getAlunoById(Long id) throws BadRequestException {
		Aluno alunoTemp = alunoRep.findById(id).orElseThrow(() -> new BadRequestException("O aluno não foi encontrado"));
		return alunoTemp;
	}
	public List<Aluno> getAllAlunos(){
		return alunoRep.findAll();
	}

}
