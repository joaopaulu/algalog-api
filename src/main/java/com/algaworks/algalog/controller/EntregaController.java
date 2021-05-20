package com.algaworks.algalog.controller;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@RequestBody Entrega entrega){
        return service.solicitar(entrega);
    }
}
