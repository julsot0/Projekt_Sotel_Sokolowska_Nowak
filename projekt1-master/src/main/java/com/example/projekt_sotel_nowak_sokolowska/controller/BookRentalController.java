package com.example.projekt_sotel_nowak_sokolowska.controller;

import com.example.projekt_sotel_nowak_sokolowska.Error.ResourceNotFoundException;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.BookRentals;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRentalsRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class BookRentalController {

    @Autowired
    private BookRentalsRepository bookRentalsRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/all")
    public List<BookRentals> findAll(){
        return bookRentalsRepository.findAll();
    }

    //nie dziala
    @Transactional
    @PostMapping("/addRental")
    public ResponseEntity<String> addRental(@RequestBody BookRentals br) {
        for (Book book : br.getBorrowedBooks()) {
            if (!book.isAvailable()) {
                return ResponseEntity.ok().body("You can't borrow an unavailable book");
            }
        }
        for (Book book : br.getBorrowedBooks()) {
            bookRepository.updateAvailability(book.getId(), false);
            BookRentals savedRental = bookRentalsRepository.save(br);
        }
        return ResponseEntity.ok().body("Successfully added a new rental");
    }
    /*
    {
    "reader": {
        "id": 4
    },
    "borrowedBooks": [
        {
            "id": 1
        },
        {
            "id": 2
        }
    ],
    "borrowedDate": "2024-05-30"
    }
     */

    @DeleteMapping("/deleteRental/{id}")
    public ResponseEntity<String> deleteRental(@PathVariable(value = "id") Long bookRentalId)
            throws ResourceNotFoundException {
        BookRentals br = bookRentalsRepository.findById(bookRentalId)
                .orElseThrow(() -> new ResourceNotFoundException("BookRental not found with id " + bookRentalId));
//        for (Book book : br.getBorrowedBooks()) {
//            bookRepository.updateAvailability(book.getId(), true);
//            BookRentals savedRental = bookRentalsRepository.save(br);
//        }
        bookRentalsRepository.delete(br);

        return ResponseEntity.ok().body("Rental deleted succesfully");
    }

    /*
    {
    "reader": {
        "id": 1
    },
    "borrowedBooks": [
        {
            "id": 1
        }
    ],
    "borrowedDate": "2024-05-30"
}
     */

}
