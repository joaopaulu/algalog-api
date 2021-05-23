package com.algaworks.algalog.service;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.service.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private final EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }
}
