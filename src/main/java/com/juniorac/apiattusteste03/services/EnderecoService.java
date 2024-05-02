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
        if (enderecoSalvo.getEnderecoPrincipal()) endereco.getPessoa().setIdEnderecoPrincipal(enderecoSalvo.getId());
        return enderecoSalvo;
    }

    public Endereco update(Long id, Endereco enderecoAtualizado) {
        Endereco endereco = enderecoRepository.getReferenceById(id);
        atualizaEndereco(endereco, enderecoAtualizado);
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return enderecoSalvo;
    }

    private void atualizaEndereco(Endereco endereco, Endereco enderecoAtualizado) {
        if (enderecoAtualizado.getLogradouro() != null) endereco.setLogradouro(enderecoAtualizado.getLogradouro());
        if (enderecoAtualizado.getCep() != null) endereco.setCep(enderecoAtualizado.getCep());
        if (enderecoAtualizado.getNumero() != null) endereco.setNumero(enderecoAtualizado.getNumero());
        if (enderecoAtualizado.getCidade() != null) endereco.setCidade(enderecoAtualizado.getCidade());
        if (enderecoAtualizado.getEstado() != null) endereco.setEstado(enderecoAtualizado.getEstado());
        if (endereco.getPessoa() != null) endereco.setPessoa(enderecoAtualizado.getPessoa());
        if (endereco.getEnderecoPrincipal() != null) endereco.setEnderecoPrincipal(enderecoAtualizado.getEnderecoPrincipal());
        if (endereco.getEnderecoPrincipal()) endereco.getPessoa().setIdEnderecoPrincipal(endereco.getId());
        for (Endereco e : endereco.getPessoa().getEnderecos()) {
            if (e.getId() != endereco.getPessoa().getIdEnderecoPrincipal()) e.setEnderecoPrincipal(false);
        }
    }
}
