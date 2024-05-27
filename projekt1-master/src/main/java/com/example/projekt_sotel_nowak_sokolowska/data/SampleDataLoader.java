package com.example.projekt_sotel_nowak_sokolowska.data;

import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.BookRentals;
import com.example.projekt_sotel_nowak_sokolowska.model.Reader;
import com.example.projekt_sotel_nowak_sokolowska.repository.AuthorRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRentalsRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final BookRentalsRepository bookRentalsRepository;

    @Autowired
    public SampleDataLoader(AuthorRepository authorRepository, BookRepository bookRepository, ReaderRepository readerRepository, BookRentalsRepository bookRentalsRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
        this.bookRentalsRepository = bookRentalsRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        //String firstname, String lastname, LocalDate releaseDate
        Author author1 = new Author("Adam", "Mickiewicz", LocalDate.of(1798,12,13));
        Author author2 = new Author("Juliusz", "Słowacki", LocalDate.of(1809, 9, 4));
        Author author3 = new Author("Henryk", "Sienkiewicz", LocalDate.of(1846, 5, 5));
        Author author4 = new Author("Stanisław", "Lem", LocalDate.of(1921, 9, 12));
        Author author5 = new Author("Joanne", "Rowling", LocalDate.of(1965, 7, 31));

        authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4, author5));

        //String title, Author author, String category, LocalDate birthYear, boolean isAvailable
        Book book1 = new Book("Pan Tadeusz", author1, "poemat epicki",
                LocalDate.of(1834,6,26), false);
        Book book2 = new Book("Dziady", author1, "poemat dramatyczny",
                LocalDate.of(1822, 6, 26), false);
        Book book3 = new Book("Balladyna", author2, "dramat",
                LocalDate.of(1839, 9, 3), false);
        Book book4 = new Book("Quo Vadis", author3, "powieść historyczna",
                LocalDate.of(1896, 12, 26), false);
        Book book5 = new Book("Solaris", author4, "science fiction",
                LocalDate.of(1961, 6, 1), false);
        Book book6 = new Book("Harry Potter and the Philosopher's Stone", author5, "fantasy",
                LocalDate.of(1997, 6, 26), false);
        Book book7 = new Book("Harry Potter and the Chamber of Secrets", author5, "fantasy",
                LocalDate.of(1998, 7, 2), true);
        Book book8 = new Book("Harry Potter and the Prisoner of Azkaban", author5, "fantasy",
                LocalDate.of(1999, 7, 8), true);
        Book book9 = new Book("Harry Potter and the Goblet of Fire", author5, "fantasy",
                LocalDate.of(2000, 7, 8), true);
        Book book10 = new Book("Harry Potter and the Order of the Phoenix", author5, "fantasy",
                LocalDate.of(2003, 6, 21), true);
        Book book11 = new Book("Harry Potter and the Half-Blood Prince", author5, "fantasy",
                LocalDate.of(2005, 7, 16), false);
        Book book12 = new Book("Harry Potter and the Deathly Hallows", author5, "fantasy",
                LocalDate.of(2007, 7, 21), true);
        Book book13 = new Book("W pustyni i w puszczy", author3, "powieść przygodowa",
                LocalDate.of(1911, 7, 1), false);
        Book book14 = new Book("Krzyżacy", author3, "powieść historyczna",
                LocalDate.of(1900, 1, 1), true);
        Book book15 = new Book("Potop", author3, "powieść historyczna",
                LocalDate.of(1886, 1, 1), false);
        Book book16 = new Book("Faraon", author3, "powieść historyczna",
                LocalDate.of(1897, 1, 1), false);
        Book book17 = new Book("Lalka", author3, "powieść realistyczna",
                LocalDate.of(1890, 1, 1), true);
        Book book18 = new Book("Niezwyciężony", author4, "science fiction",
                LocalDate.of(1964, 1, 1), false);
        Book book19 = new Book("Głos Pana", author4, "science fiction",
                LocalDate.of(1968, 1, 1),true);
        Book book20 = new Book("Powrót z gwiazd", author4, "science fiction",
                LocalDate.of(1961, 1, 1), false);
        Book book21 = new Book("Cyberiada", author4, "science fiction",
                LocalDate.of(1965, 1, 1), false);
        Book book22 = new Book("Bajki robotów", author4, "science fiction",
                LocalDate.of(1964, 1, 1), false);
        Book book23 = new Book("Beniowski", author2, "poemat dygresyjny",
                LocalDate.of(1841, 1, 1), true);
        Book book24 = new Book("Kordian", author2, "dramat",
                LocalDate.of(1834, 1, 1), true);
        Book book25 = new Book("Mazepa", author2, "dramat",
                LocalDate.of(1839, 1, 1), true);
        Book book26 = new Book("Lilla Weneda", author2, "dramat",
                LocalDate.of(1840, 1, 1), true);

        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7,
                book8, book9, book10, book11, book12, book13, book14, book15, book16, book17,
                book18, book19, book20, book21, book22, book23, book24, book25, book26));

        //String firstname, String lastname, String email
        Reader reader1 = new Reader("Natalia", "Nowak", "natalianowak@gmail.com");
        Reader reader2 = new Reader("Jan", "Kowalski", "jankowalski@gmail.com");
        Reader reader3 = new Reader("Anna", "Wiśniewska", "annawisniewska@gmail.com");
        Reader reader4 = new Reader("Piotr", "Dąbrowski", "piotrdabrowski@gmail.com");
        Reader reader5 = new Reader("Karolina", "Lis", "karolinalis@gmail.com");

        readerRepository.saveAll(Arrays.asList(reader1, reader2, reader3, reader4, reader5));

        //BookRental reader, List<Book> borrowedBooks, LocalDate borrowedDate
        BookRentals br1 = new BookRentals(reader1, List.of(book6, book1), LocalDate.of(2024, 5, 4));
        BookRentals br2 = new BookRentals(reader2, List.of(book3, book4, book2), LocalDate.of(2024, 4, 14));
        BookRentals br3 = new BookRentals(reader3, List.of(book5, book11), LocalDate.of(2024, 6, 25));
        BookRentals br4 = new BookRentals(reader4, List.of(book20, book21, book22), LocalDate.of(2024, 5, 16));
        BookRentals br5 = new BookRentals(reader5, List.of(book15, book13, book16, book18), LocalDate.of(2024, 4, 27));

        bookRentalsRepository.saveAll(Arrays.asList(br1, br2, br3, br4, br5));
    }
}
