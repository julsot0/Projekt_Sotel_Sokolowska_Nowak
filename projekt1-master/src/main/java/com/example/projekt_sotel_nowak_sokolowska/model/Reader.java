package com.example.projekt_sotel_nowak_sokolowska.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    public Reader() { }
    public Reader(String firstname, String lastname, String email)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}
