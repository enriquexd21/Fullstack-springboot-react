package com.civa.busesapi;

import com.civa.busesapi.model.Bus;
import com.civa.busesapi.model.Marca;
import com.civa.busesapi.repository.BusRepository;
import com.civa.busesapi.repository.MarcaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final BusRepository busRepository;
    private final MarcaRepository marcaRepository;

    public DataSeeder(BusRepository busRepository, MarcaRepository marcaRepository) {
        this.busRepository = busRepository;
        this.marcaRepository = marcaRepository;
    }

    @Override
    public void run(String... args) {
        if (marcaRepository.count() == 0) {
            Marca volvo = new Marca();
            volvo.setNombre("Volvo");
            marcaRepository.save(volvo);

            Bus bus = new Bus();
            bus.setNumeroBus("001");
            bus.setPlaca("ABC-123");
            bus.setCaracteristicas("Bus de 2 pisos");
            bus.setActivo(true);
            bus.setMarca(volvo);
            busRepository.save(bus);
        }
    }
}