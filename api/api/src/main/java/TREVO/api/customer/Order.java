package TREVO.api.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "customer")
@Entity(name = "Order")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cod")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    @NotBlank
    private String name;
    @NotNull
    private String  phone;
    @Column(name = "e_mail",unique = true)
    private String e_mail;
    @NotBlank
    private String country;
    private Integer id_register;
    private Integer id_product;
    private Boolean ativo;

    public Order(DadosCadastroCliente dados) {
        this.name = dados.name();
        this.phone = dados.phone();
        this.e_mail = dados.e_mail();
        this.country = dados.country();
        this.id_register = dados.id_register();
        this.id_product = dados.id_product();
        this.ativo = true;
    }

    public void atualizar(DadosCadastroCliente dados) {
        if (dados.name() != null){
            this.name = dados.name();
        }
        if (dados.phone() != null){
            this.phone = dados.phone();
        }
        if (dados.e_mail() != null){
            this.e_mail = dados.e_mail();
        }
        if (dados.country() != null){
            this.country = dados.country();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
