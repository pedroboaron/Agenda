package com.pedro.pessoasservice.controller;

import com.pedro.pessoasservice.event.RecursoCriadoEvent;
import com.pedro.pessoasservice.model.Pessoa;
import com.pedro.pessoasservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Pessoa> save(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        Pessoa save = pessoaService.save(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @CrossOrigin
    @GetMapping("/agenda")
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    @CrossOrigin
    @GetMapping("/id")
    public ResponseEntity<Pessoa> findById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<Pessoa> alterarPessoa(@RequestParam("id") Integer id,
                                                @Valid @RequestBody Pessoa pessoa,
                                                HttpServletResponse response) throws Exception {

        Pessoa save = this.pessoaService.update(id, pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.ok(save);
    }

    @CrossOrigin
    @DeleteMapping
    public ResponseEntity deleteById (@RequestParam("id") Integer id) throws Exception {
        pessoaService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}