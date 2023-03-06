package TREVO.api.sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "sale")
@Entity(name = "Sale")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String information;
    private Integer id_product;
    private Boolean ativo;

    public Sale(DadosSale dados) {
        this.id = dados.id();
        this.information = dados.information();
        this.id_product = dados.id_product();
        this.ativo = true;
    }

    public void atualizar(DadosSale dados) {
        if (dados.information() != null){
            this.information = dados.information();
        }
        if (dados.id_product() != null){
            this.id_product = dados.id_product();
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}
