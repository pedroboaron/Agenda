package com.pedro.pessoasservice.service;

import com.pedro.pessoasservice.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPessoaService {

    List<Pessoa> findAll();

    Page<Pessoa> findAll(Pageable pageable);

    Pessoa save(Pessoa cartao);

    Pessoa update(Integer id, Pessoa Pessoa) throws Exception;

    List<Pessoa> findByEmailContaining(String email);

    List<Pessoa> findByTelefoneContaining(String telefone);

    void deleteById(Integer id) throws Exception;

    List<Pessoa> findByTelefoneContainingOrEmailContainingOrEnderecoContainingOrNomeContaining (String telefone,String email,String endereco,String nome);

    Pessoa findById(Integer id);

    List<Pessoa> findByEnderecoContaining(String endereco);

    List<Pessoa> findByNomeContaining(String nome);
}
