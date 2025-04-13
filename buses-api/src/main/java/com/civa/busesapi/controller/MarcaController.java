package com.civa.busesapi.controller;

import com.civa.busesapi.model.Marca;
import com.civa.busesapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "http://localhost:3000") 
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }
}
