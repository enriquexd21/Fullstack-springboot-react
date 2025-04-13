package com.civa.busesapi.service;

import com.civa.busesapi.model.Bus;
import com.civa.busesapi.model.Marca;
import com.civa.busesapi.repository.BusRepository;
import com.civa.busesapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Bus> listarTodos() {
        return busRepository.findAll();
    }

    public Optional<Bus> buscarPorId(Long id) {
        return busRepository.findById(id);
    }

    public Bus guardar(Bus bus) {
        if (bus.getMarca() != null && bus.getMarca().getId() != null) {
            Marca marca = marcaRepository.findById(bus.getMarca().getId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + bus.getMarca().getId()));
            bus.setMarca(marca);
        } else {
            throw new RuntimeException("El campo 'marca' es obligatorio y debe tener un ID.");
        }
    
        return busRepository.save(bus);
    }

    public void eliminar(Long id) {
        busRepository.deleteById(id);
    }
}
