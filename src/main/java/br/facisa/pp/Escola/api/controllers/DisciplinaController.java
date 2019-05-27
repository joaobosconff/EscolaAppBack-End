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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.facisa.pp.Escola.api.domains.Disciplina;
import br.facisa.pp.Escola.api.services.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	//buscar disciplina por serie
	
	
	@Autowired
	private DisciplinaService disService;
	
	@GetMapping()
	public ResponseEntity<List<Disciplina>> getAllDisciplina(){
		return new ResponseEntity<List<Disciplina>>(disService.getAllDisciplina(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Long id){
		return new ResponseEntity<Disciplina>(disService.getDisciplinaById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Disciplina> updateDisciplina(@PathVariable Long id,Disciplina dis){
		return new ResponseEntity<Disciplina>(disService.updateDisciplina(id, dis),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Disciplina> createDisciplina(@RequestBody Disciplina dis){
		return new ResponseEntity<Disciplina>(disService.createDisciplina(dis),HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDisciplina(@PathVariable Long id){
		return new ResponseEntity<String>(disService.deleteDisciplina(id),HttpStatus.OK);
	}
	
	@GetMapping("/searchBySerie")
	public ResponseEntity<List<Disciplina>> getDisciplinaBySerie(@RequestParam int serie){
		return new ResponseEntity<List<Disciplina>>(disService.getDisciplinaBySerie(serie),HttpStatus.OK);
	}
}
