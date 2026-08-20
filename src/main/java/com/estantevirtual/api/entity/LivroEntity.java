package com.estantevirtual.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_livros")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;

    @Column(columnDefinition = "TEXT")
    private String capaUrl;

    private int totalPaginas;
    private String statusLeitura; // "QUERO_LER", "LENDO", "LIDO"

    @Column(columnDefinition = "TEXT")
    private String review;

    private int nota; // 1 a 5

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    public LivroEntity() {}

    public LivroEntity(String titulo, String autor, String capaUrl, int totalPaginas, String statusLeitura, String review, int nota) {
        this.titulo = titulo;
        this.autor = autor;
        this.capaUrl = capaUrl;
        this.totalPaginas = totalPaginas;
        this.statusLeitura = statusLeitura;
        this.review = review;
        this.nota = nota;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getCapaUrl() { return capaUrl; }
    public void setCapaUrl(String capaUrl) { this.capaUrl = capaUrl; }

    public int getTotalPaginas() { return totalPaginas; }
    public void setTotalPaginas(int totalPaginas) { this.totalPaginas = totalPaginas; }

    public String getStatusLeitura() { return statusLeitura; }
    public void setStatusLeitura(String statusLeitura) { this.statusLeitura = statusLeitura; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public int getNota() { return nota; }
    public void setNota(int nota) { this.nota = nota; }

    public UsuarioEntity getUsuario() {return usuario;}
    public void setUsuario(UsuarioEntity usuario) {this.usuario = usuario;}


}