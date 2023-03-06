package TREVO.api.customer;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        Long cod,
        @NotBlank
        String name,
        @NotBlank
        String phone,
        @NotBlank
        @Column(name = "e_mail",unique = true)
        String e_mail,
        @NotBlank
        String country,
        Integer id_register,
        Integer id_product) {
}
