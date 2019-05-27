package br.facisa.pp.Escola.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.pp.Escola.api.domains.Aluno;
import br.facisa.pp.Escola.api.domains.Disciplina;
import br.facisa.pp.Escola.api.domains.Nota;
import br.facisa.pp.Escola.api.domains.dtos.AlunoCreateDto;
import br.facisa.pp.Escola.api.domains.dtos.NotaDto;
import br.facisa.pp.Escola.api.exceptions.BadRequestException;
import br.facisa.pp.Escola.api.repositories.AlunoRepository;
import br.facisa.pp.Escola.api.repositories.NotaRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRep;
	
	@Autowired
	private NotaRepository notaRep;
	
	@Autowired
	private DisciplinaService disService;

	public Aluno createAluno(AlunoCreateDto alunoDto) {
		Aluno aluno = new Aluno(alunoDto);
		ArrayList<Nota> notasAluno = new ArrayList<Nota>();
		for (Long idDis : alunoDto.getIdDisciplinas()) {
			Disciplina disciplina = disService.getDisciplinaById(idDis);
			Nota nota = new Nota(disciplina);
			notaRep.save(nota);
			notasAluno.add(nota);
			
		}
		aluno.setNotas(notasAluno);
		return alunoRep.save(aluno);
	}

	public String deleteAluno(Long id) {
		alunoRep.deleteById(id);
		return "deletado";
	}

	public Aluno updateAluno(Long id, Aluno aluno) {
		if (alunoRep.existsById(id)) {
			aluno.setId(id);
			return alunoRep.saveAndFlush(aluno);
		} else {
			return null;
		}

	}

	public Aluno getAlunoById(Long id) throws BadRequestException {
		return alunoRep.findById(id).orElseThrow(() -> new BadRequestException("O aluno não foi encontrado"));

	}

	public List<Aluno> getAllAlunos() {
		return alunoRep.findAll();
	}

	public Aluno atualizarNota(Long id, Long idDisciplina, NotaDto notaDto) {
		Aluno aluno = this.getAlunoById(id);
		List<Nota> notasAluno = aluno.getNotas();
		for (Nota notaAluno : notasAluno) {
			if (notaAluno.getDisciplina().getId() == idDisciplina) {
				if (notaDto.getNota1() != null) {
					notaAluno.setNota1(notaDto.getNota1());
				}
				if (notaDto.getNota2() != null) {
					notaAluno.setNota2(notaDto.getNota2());
				}
				if (notaDto.getNota3() != null) {
					notaAluno.setNota3(notaDto.getNota3());
				}
				double media = (notaAluno.getNota1() + notaAluno.getNota2() + notaAluno.getNota3()) / 3;
				notaAluno.setMedia(media);
			}
			

		}
		return alunoRep.saveAndFlush(aluno);
	}

}
