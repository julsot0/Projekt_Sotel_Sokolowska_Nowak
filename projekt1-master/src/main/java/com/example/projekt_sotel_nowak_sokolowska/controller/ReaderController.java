package com.example.projekt_sotel_nowak_sokolowska.controller;

import com.example.projekt_sotel_nowak_sokolowska.Error.ResourceNotFoundException;
import com.example.projekt_sotel_nowak_sokolowska.model.Author;
import com.example.projekt_sotel_nowak_sokolowska.model.Book;
import com.example.projekt_sotel_nowak_sokolowska.model.BookRentals;
import com.example.projekt_sotel_nowak_sokolowska.model.Reader;
import com.example.projekt_sotel_nowak_sokolowska.repository.AuthorRepository;
import com.example.projekt_sotel_nowak_sokolowska.repository.ReaderRepository;
import com.example.projekt_sotel_nowak_sokolowska.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private ReaderService readerService;

    @GetMapping("/all")
    private List<Reader> findAll(){
        return readerRepository.findAll();
    }

    @PostMapping("/addReader")
    public Reader addReader(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }

    @DeleteMapping("/deleteReader/{id}")
    public ResponseEntity<String> deleteReader(@PathVariable Long id) {
        Reader reader = readerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found with id " + id));

        readerRepository.delete(reader);

        return ResponseEntity.ok().body("Reader deleted succesfully");
    }

    @PutMapping("/updateReader/{id}")
    public ResponseEntity<Reader> updateReader(@PathVariable(value = "id") Long readerId,
                                               @RequestBody Reader readerDetails) throws ResourceNotFoundException {
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found for this id :: " + readerId));

        reader.setFirstname(readerDetails.getFirstname());
        reader.setLastname(readerDetails.getLastname());
        reader.setEmail(readerDetails.getEmail());

        final Reader updatedReader = readerRepository.save(reader);
        return ResponseEntity.ok(updatedReader);
    }
}
