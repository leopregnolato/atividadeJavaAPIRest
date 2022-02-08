package com.gft.atividade.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.gft.atividade.DTO.FornecedorDTO;
import com.gft.atividade.Entities.Fornecedor;
import com.gft.atividade.Mappers.FornecedorMapper;
import com.gft.atividade.Services.FornecedorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fornecedores")
public class FornecedorController {


    private final FornecedorService fornecedorService;
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    public FornecedorService getFornecedorService() {
        return fornecedorService;
    }

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> buscarTodosOsFornecedores() {
        return ResponseEntity.ok(fornecedorService.listarTodosOsFornecedores().stream().map(FornecedorMapper::fromEntity).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> salvarFornecedor(@RequestBody FornecedorDTO dto) {
        Fornecedor fornecedor = fornecedorService.salvarFornecedor(FornecedorMapper.fromDTO(dto));
        return ResponseEntity.ok(FornecedorMapper.fromEntity(fornecedor));
        
    }

    
}
