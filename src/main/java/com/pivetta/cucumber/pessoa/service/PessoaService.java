package com.pivetta.cucumber.pessoa.service;

import com.pivetta.cucumber.pessoa.model.Pessoa;
import java.util.List;

public interface PessoaService {

    List<Pessoa> init();

    Pessoa save(Pessoa pessoa);

    List<Pessoa> findAll();

    Pessoa update(Pessoa pessoaAtualizada);

    void delete(long id);
}
