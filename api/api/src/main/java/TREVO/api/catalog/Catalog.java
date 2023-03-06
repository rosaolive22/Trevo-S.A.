package TREVO.api.catalog;

import TREVO.api.product.DadosProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "catalog")
@Entity(name = "Catalog")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cod")


public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;
    private Integer id_product;
    @Enumerated(EnumType.STRING)
    private Culture culture;
    private Long id_company;
    private Boolean ativo;

    public Catalog(ONCatalog dados) {
        this.cod = dados.cod();
        this.id_product = dados.id_product();
        this.culture = dados.culture();
        this.id_company = dados.id_company();
        this.ativo = true;
    }
    public void atualizar(ONCatalog dados) {
        if(dados.id_product() != null){
            this.id_product = dados.id_product();
        }
        if(dados.culture() != null){
            this.culture = dados.culture();
        }
        if(dados.id_company() != null){
            this.id_company = dados.id_company();
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}

