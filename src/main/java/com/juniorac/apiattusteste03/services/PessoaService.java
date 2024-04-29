package com.juniorac.apiattusteste03.services;

import com.juniorac.apiattusteste03.entities.Pessoa;
import com.juniorac.apiattusteste03.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        List<Pessoa> listaDePessoas = pessoaRepository.findAll();
        return listaDePessoas;
    }

    public Pessoa findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        return pessoa;
    }

    public Pessoa insert(Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return pessoaSalva;
    }
}
