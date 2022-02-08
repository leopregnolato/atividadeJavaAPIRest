package com.gft.atividade.Mappers;

import com.gft.atividade.DTO.FornecedorDTO;
import com.gft.atividade.Entities.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor fromDTO(FornecedorDTO dto) {
        return new Fornecedor(dto.getId(),  dto.getNome(), dto.getTelefone(),
        dto.getEmail(), dto.getEndereco(), dto.getCnpj());
    }
    
    public static FornecedorDTO fromEntity(Fornecedor fornecedor) {
        return new FornecedorDTO(fornecedor.getId(), fornecedor.getCnpj(), fornecedor.getNome(), fornecedor.getTelefone(),
        fornecedor.getEmail(), fornecedor.getEndereco());
    }
}
