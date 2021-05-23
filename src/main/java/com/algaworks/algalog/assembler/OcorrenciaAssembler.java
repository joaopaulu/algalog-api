package com.algaworks.algalog.assembler;

import com.algaworks.algalog.model.Ocorrencia;
import com.algaworks.algalog.model.dto.OcorrenciaDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private final ModelMapper modelMapper;

    public OcorrenciaDTO toModel(Ocorrencia ocorrencia){
        return  modelMapper.map(ocorrencia, OcorrenciaDTO.class);
    }

    public List<OcorrenciaDTO> toCollectionModel(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
    }
}
