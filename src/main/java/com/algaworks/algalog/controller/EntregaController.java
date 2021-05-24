package com.algaworks.algalog.controller;

import com.algaworks.algalog.assembler.EntregaAssembler;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.dto.EntregaDTO;
import com.algaworks.algalog.model.dto.input.EntregaInput;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.EntregaService;
import com.algaworks.algalog.service.FinalizacaoEntregaService;
import lombok.AllArgsConstructor;
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

    private final FinalizacaoEntregaService finalizacaoEntregaService;

    private final EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput){
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
        Entrega entregaSolicitada = service.solicitar(novaEntrega);

        return entregaAssembler.toModel(entregaSolicitada);
    }

    @PutMapping("{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);
    }

    @GetMapping
    public List<EntregaDTO> listar(){
        return entregaAssembler.toCollectionModel(repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<EntregaDTO> buscar(@PathVariable Long id){
        return repository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
