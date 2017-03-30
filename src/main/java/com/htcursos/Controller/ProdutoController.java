package com.htcursos.Controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.htcursos.Produto.Produto;
import com.htcursos.Produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @JsonView(Produto.class)
    @RequestMapping(method = RequestMethod.GET )
    public ResponseEntity<Collection<Produto>> buscarTodas() {
        return ResponseEntity.status(200).body(produtoRepository.buscarTodos());
    }

    @JsonView(Produto.class)
    @RequestMapping(method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity salvar(@RequestBody Produto produto){
        produtoRepository.salvar(produto);
        return ResponseEntity.status(200).body(produto.getId());
    }

    @JsonView(Produto.class)
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    private Produto buscarPelo(@PathVariable("id") int id){
        return produtoRepository.buscarPelo(id);
    }

    @JsonView(Produto.class)
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    private ResponseEntity remover(@PathVariable("id") int id){
        produtoRepository.excluir(id);
        return  ResponseEntity.status(200).body("Removido Com Sucesso!");
    }
}
