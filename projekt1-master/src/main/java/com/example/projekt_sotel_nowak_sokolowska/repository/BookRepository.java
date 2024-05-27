package com.example.projekt_sotel_nowak_sokolowska.repository;

import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);
    List<Book> findBooksByAuthorFirstnameContainingIgnoreCase(String s);
    List<Book> findAllByOrderByAuthorFirstnameAsc();
    List<Book> findAllByOrderByAuthorFirstnameDesc();
    List<Book> findBooksByTitleContainingIgnoreCase(String s);
    List<Book> findBooksByOrderByTitleAsc();
    List<Book> findBooksByOrderByTitleDesc();
    List<Book> findBooksByCategoryContainingIgnoreCase(String s);
    List<Book> findBooksByOrderByCategoryAsc();
    List<Book> findBooksByOrderByCategoryDesc();
    List<Book> findBooksByOrderByReleaseDateAsc();
    List<Book> findBooksByOrderByReleaseDateDesc();
    List<Book> findByAvailableTrue();
    List<Book> findByAvailableFalse();

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.available = :isAvailable WHERE b.id = :bookId")
    void updateAvailability(@Param("bookId") Long bookId, @Param("isAvailable") boolean isAvailable);
}
