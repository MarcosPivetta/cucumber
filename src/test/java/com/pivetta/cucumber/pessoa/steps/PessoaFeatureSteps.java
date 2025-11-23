package com.pivetta.cucumber.pessoa.steps;

import com.pivetta.cucumber.pessoa.model.Pessoa;
import com.pivetta.cucumber.pessoa.service.PessoaService;
import com.pivetta.cucumber.pessoa.service.PessoaServiceImpl;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.assertj.core.api.Assertions;
import java.util.List;

public class PessoaFeatureSteps {

    private final PessoaService pessoaService = new PessoaServiceImpl();
    private List<Pessoa> pessoaList;
    private int pessoaInitSize = 0;
    private int pessoaSizeAfterSave;
    private Pessoa savedPessoa;

    @Dado("que eu tenho um metodo estatico que inicializa uma lista de pessoas")
    public void que_eu_tenho_um_metodo_estatico_que_inicializa_uma_lista_de_pessoas() {
        initPersonList();
    }

    @Quando("eu conecto posso ver o tanho da lista inicializada de pessoas")
    public void eu_conecto_posso_ver_o_tanho_da_lista_inicializada_de_pessoas() {
        pessoaInitSize = pessoaList.size();
    }

    @Entao("o tamanho da lista e igual a 3")
    public void o_tamanho_da_lista_e_igual_a_3() {
        Assertions.assertThat(pessoaInitSize).isEqualTo(3);
    }

    @Dado("a lista de pessoas contendo 3 pessoas ja armazenadas")
    public void a_lista_de_pessoas_contendo_3_pessoas_ja_armazenadas() {
        initPersonList();
        pessoaInitSize = pessoaList.size();
    }

    @Quando("eu crio uma nova pessoa com entradas aleatorias")
    public void eu_crio_uma_nova_pessoa_com_entradas_aleatorias() {
        Pessoa pessoa = new Pessoa(4L,"Luisa","Balbino", 64);
        savedPessoa = pessoaService.save(pessoa);

        findAllPersons();
        pessoaSizeAfterSave = pessoaList.size();
    }

    @Entao("obtenho o ID da nova pessoa e a lista contem mais que 3 pessoas")
    public void obtenho_o_id_da_nova_pessoa_e_a_lista_contem_mais_que_3_pessoas() {
        Assertions.assertThat(pessoaSizeAfterSave).isGreaterThan(pessoaInitSize);
        Assertions.assertThat(savedPessoa).isNotNull();
        Assertions.assertThat(savedPessoa.getId()).isNotNull();
    }

    @Quando("^eu crio uma nova pessoa com nome (.*), sobrenome (.*), e idade (.*)$")
    public void eu_crio_uma_nova_pessoa_com_nome_nome_sobrenome_sobrenome_idade_idade(String nome, String sobrenome, int idade) {
            Pessoa pessoa = new Pessoa(nome, sobrenome, idade);
            savedPessoa = pessoaService.save(pessoa);
    }

    @Entao("eu obtenho o ID da nova pessoa e a lista contem mais que 3 pessoas")
    public void eu_obtenho_o_id_da_nova_pessoa_e_a_lista_contem_mais_que_3_pessoas() {
        findAllPersons();
        Assertions.assertThat(pessoaList).hasSizeGreaterThan(3);
    }

    @Quando("^eu atualizo uma pessoa com (.*) and (.*) and (.*) and (.*)$")
    public void eu_atualizo_uma_pessoa_com_id_nome_sobrenome_idade(Long id, String nome, String sobrenome, int idade) {
        Pessoa pessoaAtualizada = new Pessoa(id, nome, sobrenome, idade);
        savedPessoa = pessoaService.update(pessoaAtualizada);
    }

    @Entao("eu obtenho a pessoa atualizada")
    public void eu_obtenho_a_pessoa_atualizada() {
        Assertions.assertThat(savedPessoa).isNotNull();
        Assertions.assertThat(savedPessoa.getId()).isNotNull();
    }

    @Quando("^eu removo uma pessoa com id (.*)$")
    public void eu_removo_uma_pessoa_com_id_1(Long id) {
        pessoaService.delete(id);
    }

    @Entao("^a pessoa com id fornecido é removida da lista e o tamanho da lista e (.*)$")
    public void a_pessoa_com_id_fornecido_é_removida_da_lista_e_o_tamanho_da_lista_e(int tamanhoEsperado) {
        findAllPersons();
        Assertions.assertThat(pessoaList).hasSize(tamanhoEsperado);
    }

    private void initPersonList() {
        pessoaList = this.pessoaService.init();
    }

    private void findAllPersons() {
        pessoaList = this.pessoaService.findAll();
    }
}
