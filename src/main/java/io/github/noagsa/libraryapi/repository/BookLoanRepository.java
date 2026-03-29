package io.github.noagsa.libraryapi.repository;

import io.github.noagsa.libraryapi.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {
}
