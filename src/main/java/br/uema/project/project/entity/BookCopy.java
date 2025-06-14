package br.uema.project.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import br.uema.project.project.entity.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_copies")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "copy_code", nullable = false, unique = true)
    private String copyCode;

    @Column(name = "shelf_location")
    private String shelfLocation;

    @Column(name = "status")
    private String status;

    @Column(name = "acquisition_date")
    private LocalDate acquisitionDate;

    @Column(name = "condition_notes")
    private String conditionNotes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
