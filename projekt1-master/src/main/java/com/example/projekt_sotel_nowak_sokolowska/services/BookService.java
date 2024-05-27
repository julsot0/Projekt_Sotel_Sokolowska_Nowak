package com.example.projekt_sotel_nowak_sokolowska.services;

import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.Reader;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.ReaderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;
    public List<Book> znajdzPrzezAutora(String s) {
        return bookRepository.findBooksByAuthorFirstnameContainingIgnoreCase(s);
    }
    public List<Book> znajdzPrzezAutoraAsc() {
        return bookRepository.findAllByOrderByAuthorFirstnameAsc();
    }
    public List<Book> znajdzPrzezAutoraDesc() {
        return bookRepository.findAllByOrderByAuthorFirstnameDesc();
    }
    public List<Book> znajdzPrzezTytul(String s) {
        return bookRepository.findBooksByTitleContainingIgnoreCase(s);
    }
    public List<Book> znajdzPrzezTytulAsc() {
        return bookRepository.findBooksByOrderByTitleAsc();
    }
    public List<Book> znajdzPrzezTytulDesc() {
        return bookRepository.findBooksByOrderByTitleDesc();
    }
    public List<Book> znajdzPrzezKategorie(String s) {
        return bookRepository.findBooksByCategoryContainingIgnoreCase(s);
    }
    public List<Book> znajdzPrzezKategorieAsc() {
        return bookRepository.findBooksByOrderByCategoryAsc();
    }
    public List<Book> znajdzPrzezKategorieDesc() {
        return bookRepository.findBooksByOrderByCategoryDesc();
    }
    public List<Book> znajdzPrzezRokAsc() {
        return bookRepository.findBooksByOrderByReleaseDateAsc();
    }
    public List<Book> znajdzPrzezRokDesc() {
        return bookRepository.findBooksByOrderByReleaseDateDesc();
    }
    public List<Book> znajdzDostepne() {
        return bookRepository.findByAvailableTrue();
    }
    public List<Book> znajdzNiedostepne() {
        return bookRepository.findByAvailableFalse();
    }

    /*
    @Transactional
    public void deleteAuthorAndSetNullForBooks(Long authorId) {
        Author authorToDelete = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Autor o podanym identyfikatorze nie istnieje"));

        List<Book> books = bookRepository.findByAuthorId(authorId);

        for (Book book : books) {
            book.setAuthor(null);
            bookRepository.save(book);
        }
        authorRepository.delete(authorToDelete);
    }
     */
}
