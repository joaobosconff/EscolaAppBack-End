package br.facisa.pp.Escola.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facisa.pp.Escola.api.domains.Professor;
import br.facisa.pp.Escola.api.services.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("{id}")
	public ResponseEntity<Professor> getProfessorById(@PathVariable Long id){
		return new ResponseEntity<Professor>(professorService.getProfessorById(id),HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Professor>> getProfessor(){
		return new ResponseEntity<List<Professor>>(professorService.getAllProfessor(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Professor> createProfessor(@RequestBody Professor prof){
		return new ResponseEntity<Professor>(professorService.createProfessor(prof),HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Professor> updateProfessor(@PathVariable Long id,@RequestBody Professor prof){
		return new ResponseEntity<Professor>(professorService.updateProfessor(id, prof),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> updateProfessor(@PathVariable Long id){
		return new ResponseEntity<String>(professorService.deleteProfessor(id),HttpStatus.OK);
	}

}
