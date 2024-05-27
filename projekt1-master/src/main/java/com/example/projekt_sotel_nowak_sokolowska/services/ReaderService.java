package com.example.projekt_sotel_nowak_sokolowska.services;

import com.example.projekt_sotel_nowak_sokolowska.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
}
