package com.estantevirtual.api.repository;

import com.estantevirtual.api.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    // O Spring entende que deve buscar na tabela 'Livro' pelo ID do 'Usuario'
    List<LivroEntity> findByUsuarioId(Long usuarioId);
}