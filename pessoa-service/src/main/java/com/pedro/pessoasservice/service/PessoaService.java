package com.pedro.pessoasservice.service;


import com.pedro.pessoasservice.model.Pessoa;
import com.pedro.pessoasservice.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements IPessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    @Override
    public Pessoa update(Integer id, Pessoa pessoa) throws Exception {
        Optional<Pessoa> retorno = this.pessoaRepository.findById(id);

        if (!retorno.isPresent()) {
            throw new Exception("Pessoa não existe no banco de dados" + id);
        }

        Pessoa pessoaSalvo = retorno.get();
        BeanUtils.copyProperties(pessoa, pessoaSalvo, "id");

        return pessoaRepository.save(pessoaSalvo);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        Optional<Pessoa> retorno = this.pessoaRepository.findById(id);

        if (!retorno.isPresent()) {
            throw new Exception("Pessoa não existe no banco de dados com o id: " + id);
        }
        pessoaRepository.deleteById(id);
    }

    @Override
    public Pessoa findById(Integer id) {
        Optional<Pessoa> resultado = this.pessoaRepository.findById(id);
        return resultado.orElse(null);
    }
}
