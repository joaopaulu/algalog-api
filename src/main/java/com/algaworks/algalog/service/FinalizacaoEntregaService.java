package com.algaworks.algalog.service;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Enum.StatusEntrega;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private final EntregaRepository entregaRepository;
    private final BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
