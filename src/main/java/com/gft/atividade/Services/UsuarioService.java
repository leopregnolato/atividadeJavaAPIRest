package com.gft.atividade.Services;

import java.util.Optional;

import com.gft.atividade.Entities.Usuario;
import com.gft.atividade.Repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarUsusarioPorEmail(String email) {
        Optional<Usuario> optional = usuarioRepository.findByEmail(email);

        if(optional.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado!");            
        }
        return optional.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return buscarUsusarioPorEmail(username);
    }


    
}
