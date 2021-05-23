package com.algaworks.algalog.service;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Ocorrencia;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OcorrenciaService {

    private final BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }
}
