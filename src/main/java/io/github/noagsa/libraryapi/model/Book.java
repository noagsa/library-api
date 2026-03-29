package io.github.noagsa.libraryapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_sequence")
    @Column(name = "book_id")
    private Long bookId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(length = 500)
    private String synopsis;
    @Column(name = "cover_image_url")
    private String coverImageUrl;
    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies;
    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn( name = "author_id")
    )
    private Set<Author> authors;
}
