package com.juniorac.apiattusteste03.services;

import com.juniorac.apiattusteste03.entities.Endereco;
import com.juniorac.apiattusteste03.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        List<Endereco> listaDeEnderecos = enderecoRepository.findAll();
        return listaDeEnderecos;
    }

    public Endereco findById(Long id) {
        Endereco endereco = enderecoRepository.findById(id).get();
        return endereco;
    }

    public Endereco insert(Endereco endereco) {
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return enderecoSalvo;
    }
}
