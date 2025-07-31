package com.escola.salas.repositories;

import com.escola.salas.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByProfessorId(Integer idProfessor);

    List<Aluno> findByProfessorIdAndNomeContainingIgnoreCase(Integer idProfessor, String nomeAluno);

}
