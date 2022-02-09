package com.gft.atividade.Controllers;

import com.gft.atividade.DTO.TokenDTO;
import com.gft.atividade.Entities.AutenticacaoForm;
import com.gft.atividade.Services.AutenticacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    AutenticacaoService autenticacaoService;


    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoForm authForm) {
        try {
            return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
        }catch(AuthenticationException ae){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
   }
    
}
