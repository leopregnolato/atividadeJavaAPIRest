package com.gft.atividade.Services;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gft.atividade.DTO.TokenDTO;
import com.gft.atividade.Entities.AutenticacaoForm;
import com.gft.atividade.Entities.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

   
    
    @Autowired
    private AuthenticationManager authManager;

    @Value("${atividade.jwt.expiration}")
    private String expiration;

    @Value("${atividade.jwt.secret}")
    private String secret;

    @Value("${atividade.jwt.issuer}")
    private String issuer;

    public TokenDTO autenticar(AutenticacaoForm authForm) throws AuthenticationException{
        Authentication autenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(authForm.getEmail(), authForm.getSenha()));
        String token = gerarToken(autenticate);
        return new TokenDTO(token);
    }

    private Algorithm criarAlgoritmo(){
        return Algorithm.HMAC256(secret);
    }

    private String gerarToken(Authentication autenticate){
        Usuario principal = (Usuario)autenticate.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return JWT.create()
            .withIssuer(issuer)
            .withExpiresAt(dataExpiracao)
            .withSubject(principal.getId().toString())
            .sign(this.criarAlgoritmo());
        
    }
}
