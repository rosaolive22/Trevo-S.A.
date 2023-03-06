package TREVO.api.controller;

import TREVO.api.company.Company;
import TREVO.api.company.CompanyRepository;
import TREVO.api.company.DadosCompany;
import TREVO.api.product.DadosProduto;
import TREVO.api.product.Product;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyRepository repository;
    @PostMapping
    public void company(@RequestBody DadosCompany dados){
        repository.save(new Company(dados));
    }
    @GetMapping(value ="/listar")
    public Page<Company> listar(@PageableDefault() Pageable paginacao) {
        //return repository.findAll(paginacao);
        //Retorna apenas registros ativos
        return  repository.findAllByAtivoTrue(paginacao);
    }
    //Id dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/atualizar/{id}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid DadosCompany dados, @PathVariable Long id){
        Company company= repository.getReferenceById(id);
        company.atualizar(dados);
        repository.save(company);
        return ResponseEntity.ok().body("Dados da Company TREVO S.A., atualizado com sucesso!");
    }
    @DeleteMapping(value = "/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        //Exclusão lógica, mantem arquivado:
        Company company= repository.getReferenceById(id);
        company.excluir();
        repository.save(company);
        //Exclui definitivamente:
        //repository.deleteById(id);
    }
}
