package TREVO.api.image;


import TREVO.api.product.DadosProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URL;

@Table(name = "image")
@Entity(name = "Image")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cod")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    private Integer id_product;

    private URL img;
    private Boolean ativo;
    public Image(LinkImage dados) {
        this.cod = dados.cod();
        this.id_product = dados.id_product();
        this.img = dados.img();
        this.ativo = true;
    }

    public void atualizar(LinkImage dados) {
        if (dados.id_product() != null){
                this.id_product = dados.id_product();
        }
        if(dados.img() != null){
            this.img = dados.img();
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}
