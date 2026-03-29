package io.github.noagsa.libraryapi.repository;

import io.github.noagsa.libraryapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
