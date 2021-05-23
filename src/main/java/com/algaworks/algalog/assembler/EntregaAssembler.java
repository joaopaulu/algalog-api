package com.algaworks.algalog.assembler;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.dto.EntregaDTO;
import com.algaworks.algalog.model.dto.input.EntregaInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private final ModelMapper modelMapper;

    public EntregaDTO toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaDTO.class);
    }

    public List<EntregaDTO> toCollectionModel(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }
}
