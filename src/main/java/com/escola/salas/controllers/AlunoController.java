package com.escola.salas.controllers;

import com.escola.salas.entities.Aluno;
import com.escola.salas.entities.Professor;
import com.escola.salas.repositories.AlunoRepository;
import com.escola.salas.repositories.ProfessorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores/{idProfessor}/aluno")
public class AlunoController {
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;

    public AlunoController(AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }

    @GetMapping
    public List<Aluno> listarAluno(@PathVariable Integer idProfessor) {
        List<Aluno> alunos = this.alunoRepository.findByProfessorId(idProfessor);
        return alunos;
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno, @PathVariable Integer idProfessor) {
        Professor professor = professorRepository.findById(idProfessor).orElseThrow();

        aluno.setProfessor(professor);

        this.alunoRepository.save(aluno);
        return aluno;
    }

    @GetMapping("/{nomeAluno}")
    public List<Aluno> buscarPorNome(
            @PathVariable Integer idProfessor,
            @PathVariable String nomeAluno
    ) {
        return alunoRepository.findByProfessorIdAndNomeContainingIgnoreCase(idProfessor, nomeAluno);
    }
}
