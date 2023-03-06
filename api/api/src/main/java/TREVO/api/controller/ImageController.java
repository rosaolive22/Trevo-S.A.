package TREVO.api.controller;

import TREVO.api.image.Image;
import TREVO.api.image.ImageRepository;
import TREVO.api.image.LinkImage;
import TREVO.api.product.DadosProduto;
import TREVO.api.product.Product;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("image")
public class ImageController {
    @Autowired
    private ImageRepository repository;
    @PostMapping
    public void image(@RequestBody LinkImage dados){
    repository.save(new Image(dados));
    }
    @GetMapping(value = "/listar")
    public Page<Image> listar(@PageableDefault(page = 0, size = 2, sort = {"img"}) Pageable paginacao) {
        return repository.findAll(paginacao);
    }
    //Id(cod) dinâmico como parâmetro que passaremos na URL do insomnia
    @PutMapping(value = "/atualizar/{cod}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid LinkImage dados, @PathVariable Long cod){
        Image image= repository.getReferenceById(cod);
        image.atualizar(dados);
        repository.save(image);
        return ResponseEntity.ok().body("Imagem atualizada com sucesso!");
    }
    @DeleteMapping(value = "/{cod}")
    @Transactional
    public void excluir(@PathVariable Long cod){
        //Exclusão lógica, mantem arquivado:
        Image image= repository.getReferenceById(cod);
        image.excluir();
        //Exclui definitivamente:
        //repository.deleteById(cod);
    }
}
