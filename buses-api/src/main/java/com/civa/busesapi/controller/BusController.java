package com.civa.busesapi.controller;

import com.civa.busesapi.model.Bus;
import com.civa.busesapi.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "*")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public List<Bus> obtenerTodos() {
        return busService.listarTodos();
    }

    @GetMapping("/{id}")
    public Bus obtenerPorId(@PathVariable Long id) {
        return busService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Bus no encontrado con ID: " + id));
    }

    @PostMapping
public Bus crearBus(@RequestBody Bus bus) {
    System.out.println("Bus recibido: " + bus); 
    return busService.guardar(bus);
}



    @PutMapping("/{id}")
    public Bus actualizarBus(@PathVariable Long id, @RequestBody Bus nuevoBus) {
        return busService.buscarPorId(id)
                .map(busExistente -> {
                    busExistente.setNumeroBus(nuevoBus.getNumeroBus());
                    busExistente.setPlaca(nuevoBus.getPlaca());
                    busExistente.setCaracteristicas(nuevoBus.getCaracteristicas());
                    busExistente.setActivo(nuevoBus.isActivo());
                    busExistente.setMarca(nuevoBus.getMarca());
                    return busService.guardar(busExistente);
                })
                .orElseThrow(() -> new RuntimeException("Bus no encontrado con ID: " + id));
    }
    @DeleteMapping("/{id}")
    public void eliminarBus(@PathVariable Long id) {
    busService.eliminar(id);
}

    
}
