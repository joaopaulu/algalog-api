package com.algaworks.algalog.service;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Enum.StatusEntrega;
import com.algaworks.algalog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class EntregaService {

    private final ClienteService service;

    private final EntregaRepository repository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = service.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return repository.save(entrega);
    }
}
