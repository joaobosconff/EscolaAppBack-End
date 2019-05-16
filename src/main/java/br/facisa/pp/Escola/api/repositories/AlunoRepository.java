package br.facisa.pp.Escola.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.facisa.pp.Escola.api.domains.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
