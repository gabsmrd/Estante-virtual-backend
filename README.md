# 📚 Estante Virtual - API REST (Backend)

API RESTful desenvolvida em **Java 21/17** e **Spring Boot 3** para gerenciamento de acervo de livros, resenhas e acompanhamento de leitura, com persistência em banco de dados **MySQL**.

---

## 🛠️ Tecnologias e Ferramentas

- **Linguagem:** Java 21 / 17
- **Framework:** Spring Boot 3
- **Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** MySQL
- **Gerenciador de Dependências:** Maven
- **Arquitetura:** Camadas (Model, Repository, Controller)

---

## 📋 Estrutura de Pastas

```text
src/main/java/com/estantevirtual/api/
├── model/
│   └── Livro.java             # Entidade JPA (tb_livros)
├── repository/
│   └── LivroRepository.java   # Interface Spring Data JPA
└── controller/
    └── LivroController.java   # Endpoints RESTful (CRUD)