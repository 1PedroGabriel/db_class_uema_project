package br.uema.project.project.dto.book;

public class AuthorDTO {
    private Long id;
    private String authors;

    public AuthorDTO(Long id, String authors) {
        this.id = id;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public String getAuthors() {
        return authors;
    }
}
