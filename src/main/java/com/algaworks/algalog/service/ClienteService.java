package com.algaworks.algalog.service;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.service.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository repository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = repository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
        }
        return repository.save(cliente);
    }

    @Transactional
    public void excluir(Long id){
        repository.deleteById(id);
    }
}
