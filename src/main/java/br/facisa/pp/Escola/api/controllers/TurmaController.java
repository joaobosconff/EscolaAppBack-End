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

import br.facisa.pp.Escola.api.domains.Turma;
import br.facisa.pp.Escola.api.services.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping("{id}")
	public ResponseEntity<Turma> getTurmaById(@PathVariable Long id){
		return new ResponseEntity<Turma>(turmaService.findTurmaById(id),HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Turma>> getTurmas(){
		return new ResponseEntity<List<Turma>>(turmaService.getAllTurmas(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Turma> createTurma(@RequestBody Turma turma){
		return new ResponseEntity<Turma>(turmaService.createTurma(turma),HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Turma> updateTurma(@PathVariable Long id,@RequestBody Turma turma){
		return new ResponseEntity<Turma>(turmaService.updateTurma(id, turma),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> updateTurma(@PathVariable Long id){
		return new ResponseEntity<String>(turmaService.deleteTurma(id),HttpStatus.OK);
	}

}
