package com.algaworks.algalog.controller;

import com.algaworks.algalog.assembler.OcorrenciaAssembler;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.Ocorrencia;
import com.algaworks.algalog.model.dto.OcorrenciaDTO;
import com.algaworks.algalog.model.dto.input.OcorrenciaInput;
import com.algaworks.algalog.service.BuscaEntregaService;
import com.algaworks.algalog.service.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService ocorrenciaService;

    private final OcorrenciaAssembler ocorrenciaAssembler;

    private final BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrar(@PathVariable Long entregaId, @Valid @RequestBody
            OcorrenciaInput ocorrenciaInput) {

        Ocorrencia ocorrenciaRegistrada = ocorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaDTO> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}
