package com.gft.atividade.Services;

import java.util.List;

import com.gft.atividade.Entities.Fornecedor;
import com.gft.atividade.Repositories.FornecedorRepository;

import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public FornecedorRepository getFornecedorRepository() {
        return fornecedorRepository;
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);        
    }

    public List<Fornecedor> listarTodosOsFornecedores() {
        return fornecedorRepository.findAll();
    }

    
    
}
