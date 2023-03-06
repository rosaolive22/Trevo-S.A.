package TREVO.api.product;

import TREVO.api.catalog.Culture;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDate;

@Table(name = "product")
@Entity(name = "Product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    @Column(name = "name", unique = true)
    private String name;
    private String size;
    @NotNull
    private Boolean status;
    private LocalDate date_register;
    private URL img;
    @NotNull
    private Integer id_catalog;
    @Enumerated(EnumType.STRING)
    private Culture culture;
    private Boolean ativo;

    //Construtores
    public Product(DadosProduto dados) {
        this.name = dados.name();
        this.size = dados.size();
        this.status = dados.status();
        this.date_register = dados.date_register();
        this.img = dados.img();
        this.id_catalog = dados.id_catalog();
        this.culture = dados.culture();
        this.ativo = true;
    }
    public void atualizar(DadosProduto dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.size() != null) {
            this.size = dados.size();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
        if(dados.img() != null){
            this.img =dados.img();
        }
        if (dados.id_catalog() != null) {
            this.id_catalog = dados.id_catalog();
        }
        if (dados.culture() != null) {
            this.culture = dados.culture();
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}
