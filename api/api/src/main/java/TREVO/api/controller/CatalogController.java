package TREVO.api.controller;

import TREVO.api.catalog.Catalog;
import TREVO.api.catalog.CatalogRepository;
import TREVO.api.catalog.ONCatalog;
import TREVO.api.product.DadosProduto;
import TREVO.api.product.Product;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalog")

public class CatalogController {
    @Autowired
    private CatalogRepository repository;
    @PostMapping
    public void catalog(@RequestBody ONCatalog dados){
        repository.save(new Catalog(dados));
    }
    @GetMapping(value ="/listar")
    public Page<Catalog> listar(@PageableDefault(page = 0, size = 10, sort = {"cod"}) Pageable paginacao) {
        return repository.findAll(paginacao);
    }
    //Id dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/atualizar/{cod}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid ONCatalog dados, @PathVariable Integer cod){
        Catalog catalog= repository.getReferenceById(cod);
        catalog.atualizar(dados);
        repository.save(catalog);
        return ResponseEntity.ok().body("Catalogo atualizado com sucesso!");
    }
    @DeleteMapping(value = "/{cod}")
    @Transactional
    public void excluir(@PathVariable Integer cod){
        //Exclusão lógica, mantem arquivado:
        Catalog catalog= repository.getReferenceById(cod);
        catalog.excluir();
        //Exclui definitivamente:
        //repository.deleteById(cod);
    }
}
