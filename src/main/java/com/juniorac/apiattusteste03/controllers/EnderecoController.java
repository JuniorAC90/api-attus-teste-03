package com.juniorac.apiattusteste03.controllers;

import com.juniorac.apiattusteste03.entities.Endereco;
import com.juniorac.apiattusteste03.repositories.EnderecoRepository;
import com.juniorac.apiattusteste03.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> listaDeEnderecos = enderecoService.findAll();
        return ResponseEntity.ok().body(listaDeEnderecos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Endereco endereco = enderecoService.findById(id);
        return ResponseEntity.ok().body(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco) {
        endereco = enderecoService.insert(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(endereco);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco) {
        endereco = enderecoService.update(id, endereco);
        return ResponseEntity.ok().body(endereco);
    }
}
