package com.algaworks.algalog.controller;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.dto.EntregaDTO;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.EntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService service;

    private final EntregaRepository repository;

    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){
        return service.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long id){
        return repository.findById(id)
                .map(entrega -> {
                    EntregaDTO entregaDTO = modelMapper.map(entrega, EntregaDTO.class);
                    return ResponseEntity.ok(entregaDTO);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
