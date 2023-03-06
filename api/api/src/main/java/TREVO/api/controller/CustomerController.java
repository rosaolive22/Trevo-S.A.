package TREVO.api.controller;

import TREVO.api.customer.Order;
import TREVO.api.customer.CustomerRepository;
import TREVO.api.customer.DadosCadastroCliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    @PostMapping
    public void customer(@RequestBody DadosCadastroCliente dados) {
        repository.save(new Order(dados));
    }
    @GetMapping(value ="/listar")
    public Page<Order> listar(Pageable paginacao){
        return repository.findAll(paginacao);
    }
    //Id dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/atualizar/{cod}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid DadosCadastroCliente dados, @PathVariable Long cod){
        Order order = repository.getReferenceById(cod);
        order.atualizar(dados);
        repository.save(order);
        return ResponseEntity.ok().body("Solicitação de orçamento efetuada com sucesso! \nEm breve um de nossos vendedores entrará em contato.  \nEquipe TREVO S.A. agradece! ");
    }
    @DeleteMapping(value = "/{cod}")
    @Transactional
    public void excluir(@PathVariable Long cod){
        //Exclusão lógica, mantem arquivado:
        Order order = repository.getReferenceById(cod);
        order.excluir();
        repository.save(order);
        //Exclui definitivamente:
        //repository.deleteById(custumer);
    }
}
