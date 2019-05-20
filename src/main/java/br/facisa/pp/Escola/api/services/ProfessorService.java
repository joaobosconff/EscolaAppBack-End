package br.facisa.pp.Escola.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.pp.Escola.api.domains.Professor;
import br.facisa.pp.Escola.api.exceptions.BadRequestException;
import br.facisa.pp.Escola.api.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository profRep;
	
	public Professor createProfessor(Professor professor) {
		return profRep.save(professor);
	}
	
	public String deleteProfessor(Long id) {
		profRep.deleteById(id);
		return "deletado";
	}
	
	public List<Professor> getAllProfessor(){
		return profRep.findAll();
	}
	
	public Professor getProfessorById(Long id) throws BadRequestException {
		return profRep.findById(id).orElseThrow(() -> new BadRequestException("O professor não foi encontrado"));
	}
	
	public Professor updateProfessor(Long id,Professor professor) {
		Professor profTemp = this.getProfessorById(id);
		profTemp.setDisciplina(professor.getDisciplina());
		profTemp.setNome(professor.getNome());
		return profRep.save(profTemp);
	}

}
