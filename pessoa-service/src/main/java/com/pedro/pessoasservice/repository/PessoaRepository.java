package com.pedro.pessoasservice.repository;

import com.pedro.pessoasservice.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    List<Pessoa> findAll();

    Page<Pessoa> findAll(Pageable pageable);

    List<Pessoa> findByEmailContaining(String email);

    List<Pessoa> findByTelefoneContaining(String telefone);

    Optional<Pessoa> findById (Integer id);

    List<Pessoa> findByEnderecoContaining (String endereco);

    List<Pessoa> findByNomeContaining (String nome);

    void deleteById (Integer id);

}
