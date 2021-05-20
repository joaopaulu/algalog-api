package com.algaworks.algalog.service;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Enum.StatusEntrega;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EntregaService {

    @Autowired
    private ClienteService service;

    @Autowired
    private EntregaRepository repository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = service.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return repository.save(entrega);
    }
}
