package com.example.projekt_sotel_nowak_sokolowska.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class BookRentals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;

    @ManyToMany
    @JoinTable(
            name = "book_rental_books",
            joinColumns = @JoinColumn(name = "book_rental_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> borrowedBooks;

    private LocalDate borrowedDate;

    public BookRentals(){}

    public BookRentals(Reader reader, List<Book> borrowedBooks, LocalDate borrowedDate){
        this.reader = reader;
        this.borrowedBooks = borrowedBooks;
        this.borrowedDate = borrowedDate;
    }
}
