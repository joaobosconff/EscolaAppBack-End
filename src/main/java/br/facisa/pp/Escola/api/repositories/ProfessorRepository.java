package br.facisa.pp.Escola.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.facisa.pp.Escola.api.domains.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}

