package TREVO.api.controller;

import TREVO.api.sale.DadosSale;
import TREVO.api.sale.Sale;
import TREVO.api.sale.SaleRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sale")
public class SaleController {
    @Autowired
    private SaleRepository repository;
    @PostMapping
    public void sale(@RequestBody DadosSale dados){
        repository.save(new Sale(dados));
    }
    @GetMapping(value = "/listar")
    public Page<Sale> listar(@PageableDefault(page = 0, size = 10, sort = {"information"}) Pageable paginacao) {
        return repository.findAll(paginacao);
    }
    //Id dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/atualizar/{id}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid DadosSale dados, @PathVariable Long id){
        Sale sale= repository.getReferenceById(id);
        sale.atualizar(dados);
        repository.save(sale);
        return ResponseEntity.ok().body("Dados do vendedor atualizado com sucesso!");
    }
    @DeleteMapping(value = "/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        //Exclusão lógica, mantem arquivado:
        Sale sale = repository.getReferenceById(id);
        sale.excluir();
        repository.save(sale);
        //Exclui definitivamente:
        //repository.deleteById(id);
    }
}
