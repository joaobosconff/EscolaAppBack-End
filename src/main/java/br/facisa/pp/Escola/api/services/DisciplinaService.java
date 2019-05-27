package br.facisa.pp.Escola.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.pp.Escola.api.domains.Disciplina;
import br.facisa.pp.Escola.api.exceptions.BadRequestException;
import br.facisa.pp.Escola.api.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disRep;

	public Disciplina createDisciplina(Disciplina dis) {
		return disRep.save(dis);
	}

	public String deleteDisciplina(Long id) {
			disRep.deleteById(id);
			return "apagado";
		} 
	

	public Disciplina updateDisciplina(Long id, Disciplina dis) {
		if (disRep.existsById(id)) {
			dis.setId(id);
			return disRep.saveAndFlush(dis);
		} else {
			return null;
		}
	}
	
	public Disciplina getDisciplinaById(Long id) {
		return disRep.findById(id).orElseThrow(() -> new BadRequestException("A Disciplina não foi encontrado"));
	}
	
	public List<Disciplina> getAllDisciplina(){
		return disRep.findAll();
	}


}
