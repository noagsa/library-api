package io.github.noagsa.libraryapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "book_loans")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_loan_generator")
    @SequenceGenerator(name = "book_loan_generator", sequenceName = "book_loan_sequence")
    @Column(name = "loan_id")
    private Long id;
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;
    @Column(name = "return_deadline", nullable = false)
    private LocalDate returnDeadline;
    @Column(name = "return_date")
    private LocalDate returnDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name ="loan_book",
            joinColumns = @JoinColumn(name = "loan_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;
}
