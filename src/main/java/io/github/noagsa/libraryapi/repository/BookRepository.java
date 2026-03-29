package io.github.noagsa.libraryapi.repository;

import io.github.noagsa.libraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
