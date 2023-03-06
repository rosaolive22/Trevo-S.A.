package TREVO.api.controller;

import TREVO.api.technical_description.DadosTechnical;
import TREVO.api.technical_description.TechnicalRepository;
import TREVO.api.technical_description.Technical_description;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("technical_description")
public class TechnicalController {
    @Autowired
    private TechnicalRepository repository;
    @PostMapping
    public void technical_description(@RequestBody DadosTechnical dados){
        repository.save(new Technical_description(dados));
    }
    @GetMapping(value ="/listar")
    public Page<Technical_description> listar(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    //Id dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/atualizar/{cod}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid DadosTechnical dados, @PathVariable Long cod){
        Technical_description technical_description= repository.getReferenceById(cod);
        technical_description.atualizar(dados);
        repository.save(technical_description);
        return ResponseEntity.ok().body("Produto atualizado com sucesso!");
    }

    @DeleteMapping(value = "/{cod}")
    @Transactional
    public void excluir(@PathVariable Long cod){
        //Exclusão lógica, mantem arquivado:
        Technical_description technical_description = repository.getReferenceById(cod);
        technical_description.excluir();
        repository.save(technical_description);
        //Exclui definitivamente:
        //repository.deleteById(cod);
    }
}
