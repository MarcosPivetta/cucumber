package com.pivetta.cucumber.pessoa.service;

import com.pivetta.cucumber.pessoa.model.Pessoa;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PessoaServiceImpl implements PessoaService {

    private final List<Pessoa> pessoaList = new ArrayList<>();

    @Override
    public List<Pessoa> init() {
        pessoaList.add(new Pessoa(1L,"Marcos", "Pivetta", 34));
        pessoaList.add(new Pessoa(2L,"Jaqueline", "Nunes", 36));
        pessoaList.add(new Pessoa(3L,"Malu", "Correia", 1));
        return pessoaList;
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        if (null == pessoa) {
            return null;
        }
        pessoa.setId((long) pessoaList.size() + 1);
        pessoaList.add(pessoa);
        return pessoa;
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaList;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        Pessoa pessoaEncontrada = findById(pessoa.getId());
        if (null == pessoaEncontrada) {
            log.error("Pessoa com id {} nao encontrada", pessoa.getId());
            return null;
        }
        pessoaEncontrada.setNome(pessoa.getNome());
        pessoaEncontrada.setSobrenome(pessoa.getSobrenome());
        pessoaEncontrada.setIdade(pessoa.getIdade());
        return pessoaEncontrada;
    }

    @Override
    public void delete(long id) {
        Pessoa pessoaEncontrada = findById(id);
        if (null == pessoaEncontrada) {
            log.error("Pessoa com id {} nao encontrada", id);
            return;
        }
        pessoaList.remove(pessoaEncontrada);
    }

    private Pessoa findById(Long id) {
        return  pessoaList.stream().filter(pessoa ->
                pessoa.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
