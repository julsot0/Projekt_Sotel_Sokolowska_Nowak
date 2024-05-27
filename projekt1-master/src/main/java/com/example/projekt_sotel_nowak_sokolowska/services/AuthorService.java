package com.example.projekt_sotel_nowak_sokolowska.services;

import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.repository.AuthorRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRentalsRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

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
}
