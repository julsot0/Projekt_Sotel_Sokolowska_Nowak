package com.example.projekt_sotel_nowak_sokolowska.repository;

import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.BookRentals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRentalsRepository extends JpaRepository<BookRentals, Long> {
    List<BookRentals> findByBorrowedBooksContains(Book book);
}
