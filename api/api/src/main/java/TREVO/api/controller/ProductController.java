package TREVO.api.controller;

import TREVO.api.product.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @PostMapping(value = "/cadastrar")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosProduto dados) {
        repository.save(new Product(dados));
        return ResponseEntity.ok().body("Produto cadastrado com sucesso!");
    }
    @GetMapping(value = "/listar")
    public Page<Product> listar(@PageableDefault(size=10, sort={"name"}) Pageable paginacao){
        //Retorna apenas registros ativos
        return  repository.findAllByAtivoTrue(paginacao);
        //Retorna todos registros
         //return  repository.findAll(paginacao);
    }
    //Id dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/atualizar/{id_product}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid DadosProduto dados,@PathVariable Long id_product){
        Product product= repository.getReferenceById(id_product);
        product.atualizar(dados);
        repository.save(product);
        return ResponseEntity.ok().body("Produto atualizado com sucesso!");
    }
    @DeleteMapping(value = "/{id_product}")
    @Transactional
    public void excluir(@PathVariable Long id_product){
        //Exclusão lógica, mantem arquivado:
        Product product = repository.getReferenceById(id_product);
        product.excluir();
        repository.save(product);
        //Exclui definitivamente:
        //repository.deleteById(id_product);
    }
}
