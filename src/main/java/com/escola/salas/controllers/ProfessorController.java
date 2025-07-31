package com.escola.salas.controllers;

import com.escola.salas.entities.Professor;
import com.escola.salas.repositories.ProfessorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;

    }

    @GetMapping
    public List<Professor> listar() {
        return this.professorRepository.findAll();
    }

    @GetMapping("/{idProfessor}")
    public Professor buscarProfessor(@PathVariable Integer idProfessor) {
        return this.professorRepository.findById(idProfessor).get();
    }

    @PostMapping
    public Professor adicionarProfessor(@RequestBody Professor professor) {
        this.professorRepository.save(professor);
        return professor;
    }
}
