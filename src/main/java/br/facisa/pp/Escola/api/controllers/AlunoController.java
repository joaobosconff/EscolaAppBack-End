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

import br.facisa.pp.Escola.api.domains.Aluno;
import br.facisa.pp.Escola.api.domains.dtos.AlunoCreateDto;
import br.facisa.pp.Escola.api.domains.dtos.NotaDto;
import br.facisa.pp.Escola.api.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	
	@Autowired
	private AlunoService alunoService;
	
	
	@GetMapping("{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id){
		return new ResponseEntity<Aluno>(alunoService.getAlunoById(id),HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Aluno>> getAlunos(){
		return new ResponseEntity<List<Aluno>>(alunoService.getAllAlunos(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Aluno> createAluno(@RequestBody AlunoCreateDto aluno){
		return new ResponseEntity<Aluno>(alunoService.createAluno(aluno),HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable Long id,@RequestBody Aluno aluno){
		return new ResponseEntity<Aluno>(alunoService.updateAluno(id, aluno),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> updateAluno(@PathVariable Long id){
		return new ResponseEntity<String>(alunoService.deleteAluno(id),HttpStatus.OK);
	}
	
	@PutMapping("{idAluno}/disciplina/{idDisciplina}")
	public ResponseEntity<Aluno> atualizarNotas(@PathVariable Long idAluno,@RequestBody NotaDto nota,@PathVariable Long idDisciplina){
		return new ResponseEntity<Aluno>(alunoService.atualizarNota(idAluno, idDisciplina, nota),HttpStatus.OK);
	}

}
