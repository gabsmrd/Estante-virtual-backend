package com.estantevirtual.api.controller;

import com.estantevirtual.api.entity.LivroEntity;
import com.estantevirtual.api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = "*")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @GetMapping
    public List<LivroEntity> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<LivroEntity> listarPorUsuario(@PathVariable Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public ResponseEntity<LivroEntity> salvar(@RequestBody LivroEntity livro) {
        LivroEntity novoLivro = repository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroEntity> atualizar(@PathVariable Long id, @RequestBody LivroEntity livroDados) {
        return repository.findById(id)
                .map(livroExistente -> {
                    livroExistente.setReview(livroDados.getReview());
                    livroExistente.setNota(livroDados.getNota());
                    livroExistente.setStatusLeitura(livroDados.getStatusLeitura());

                    LivroEntity atualizado = repository.save(livroExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}