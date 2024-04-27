package com.juniorac.apiattusteste03.repositories;

import com.juniorac.apiattusteste03.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
