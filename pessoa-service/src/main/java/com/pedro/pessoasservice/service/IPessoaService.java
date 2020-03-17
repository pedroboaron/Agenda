package com.pedro.pessoasservice.service;

import com.pedro.pessoasservice.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPessoaService {

    List<Pessoa> findAll();

    Pessoa save(Pessoa cartao);

    Pessoa update(Integer id, Pessoa Pessoa) throws Exception;

    void deleteById(Integer id) throws Exception;

    Pessoa findById(Integer id);

}
