package com.estantevirtual.api.entity;

import jakarta.persistence.*;

@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    // Campos para a barra lateral
    private Integer metaLeitura;
    private String fotoUrl;

    // Construtor com o NOME CORRETO da classe
    public UsuarioEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getMetaLeitura() {
        return metaLeitura;
    }

    public void setMetaLeitura(Integer metaLeitura) {
        this.metaLeitura = metaLeitura;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}