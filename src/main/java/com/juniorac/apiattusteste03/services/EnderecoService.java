package com.juniorac.apiattusteste03.services;

import com.juniorac.apiattusteste03.entities.Endereco;
import com.juniorac.apiattusteste03.entities.Pessoa;
import com.juniorac.apiattusteste03.repositories.EnderecoRepository;
import com.juniorac.apiattusteste03.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

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
        atualizaEnderecoPrincipal(endereco.getPessoa());
        pessoaRepository.save(endereco.getPessoa());
        return enderecoSalvo;
    }

    public Endereco update(Long id, Endereco enderecoAtualizado) {
        Endereco endereco = enderecoRepository.getReferenceById(id);
        atualizaEndereco(endereco, enderecoAtualizado);
        atualizaEnderecoPrincipal(endereco.getPessoa());
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        return enderecoSalvo;
    }

    private void atualizaEndereco(Endereco endereco, Endereco enderecoAtualizado) {
        if (enderecoAtualizado.getLogradouro() != null) endereco.setLogradouro(enderecoAtualizado.getLogradouro());
        if (enderecoAtualizado.getCep() != null) endereco.setCep(enderecoAtualizado.getCep());
        if (enderecoAtualizado.getNumero() != null) endereco.setNumero(enderecoAtualizado.getNumero());
        if (enderecoAtualizado.getCidade() != null) endereco.setCidade(enderecoAtualizado.getCidade());
        if (enderecoAtualizado.getEstado() != null) endereco.setEstado(enderecoAtualizado.getEstado());
        if (endereco.getEnderecoPrincipal() != null) endereco.setEnderecoPrincipal(enderecoAtualizado.getEnderecoPrincipal());
        if (endereco.getEnderecoPrincipal()) endereco.getPessoa().setIdEnderecoPrincipal(endereco.getId());
        for (Endereco e : endereco.getPessoa().getEnderecos()) {
            if (e.getId() != endereco.getPessoa().getIdEnderecoPrincipal()) e.setEnderecoPrincipal(false);
        }
    }

    private void atualizaEnderecoPrincipal(Pessoa pessoa) {
        Long idEnderecoPrincipal = pessoa.getIdEnderecoPrincipal();
        for (Endereco  endereco : pessoa.getEnderecos()) {
            if (idEnderecoPrincipal != endereco.getId()) {
                endereco.setEnderecoPrincipal(false);
            }
        }

        Optional<Endereco> optEnderecoPrincipal = pessoa.getEnderecos().stream().filter(p -> p.getEnderecoPrincipal()).findFirst();
        if (optEnderecoPrincipal.isEmpty()) pessoa.setIdEnderecoPrincipal(0L);
    }
}
