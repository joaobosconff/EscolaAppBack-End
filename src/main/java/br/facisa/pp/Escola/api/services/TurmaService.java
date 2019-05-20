package br.facisa.pp.Escola.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.pp.Escola.api.domains.Turma;
import br.facisa.pp.Escola.api.exceptions.BadRequestException;
import br.facisa.pp.Escola.api.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRep;

	
	public Turma createTurma(Turma turma) {
		return turmaRep.save(turma);
	}
	
	public void deleteTurma(Long id) {
		turmaRep.deleteById(id);
	}
	
	public List<Turma> getAllTurmas(){
		return turmaRep.findAll();
	}
	
	public Turma findTurmaById(Long id) throws BadRequestException {
		return turmaRep.findById(id).orElseThrow(() -> new BadRequestException("A turma não foi encontrado"));
	}
	
	public Turma updateTurma(Long id,Turma turma) {
		Turma turmaTemp = this.findTurmaById(id);
		turmaTemp.setAlunos(turma.getAlunos());
		turmaTemp.setProfessor(turma.getProfessor());
		return turmaRep.save(turmaTemp);
	}
}
