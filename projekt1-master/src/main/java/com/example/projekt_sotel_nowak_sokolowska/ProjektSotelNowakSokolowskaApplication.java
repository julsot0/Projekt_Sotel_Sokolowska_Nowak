package com.example.projekt_sotel_nowak_sokolowska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjektSotelNowakSokolowskaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjektSotelNowakSokolowskaApplication.class, args);
    }

    //Zwrot i wypożyczanie książek:
    //Nie dziala addRental -> cos jest nie tak ze sprawdzaniem dostepnosci książki (gdy boolean jest domyslnie na false to nie da sie dodac zadnej ksiazki,
    //                          natomiast gdy jest na true to wszystkie ksiazki sie dodaja mimo zmiany na false)
    //Analogicznie do addRental (wypozycz) bedzie zrobiony deleteRental (aktualnie tylko usuwa wypozyczenie ale nie zwraca ksiazkom wartosci true)
    //ewentualnie mozna sie pokusic o jakies automatyczne sprawdzanie czy ksiazka nalezy do jakiegos wypozyczenia i wtedy jej nadac wartosc true/false
    //                          (bo aktualnie jest to zrobione tylko i wylacznie recznie) ale tez nie wiem jak to zrobic

    //Zarządzanie kontami użytkowników (rejestracja, logowanie) -> nie wiem jak to zrobic

    //Generowanie raportów i statystyk dotyczących wypożyczeń i dostępnych książek -> nie wiem jak to zrobic

    //Dodac baze H2?


    //Ze zrobionych rzeczy dzialaja:
    //Przeglądanie, dodawanie, usuwanie, edytowanie książek w bibliotece.
    //Przeglądanie, dodawanie, usuwanie (+edytowanie) autorów książek.
    //Przeglądanie, dodawanie, usuwanie (+edytowanie) czytelników.
    //+extra przegladanie i usuwanie wypozyczen (tzw. BookRentals)
}
