package TREVO.api.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.Id;

@Table(name = "company")
@Entity(name = "Company")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    //@Pattern(regexp = "\\d{14}")
    private String cnpj;
    @NotBlank
    @Column(name = "name",unique = true)
    private String name;
    private String business_branch;
    private Integer founding_yeans;
    private Boolean ativo;

    public Company(DadosCompany dados) {
        this.id = dados.id();
        this.cnpj = dados.cnpj();
        this.name = dados.name();
        this.business_branch = dados.business_branch();
        this.founding_yeans = dados.founding_yeans();
        this.ativo = true;
    }
    public void atualizar(DadosCompany dados) {
        if (dados.cnpj() != null) {
            this.cnpj = dados.cnpj();
        }
        if (dados.name() != null){
            this.name = dados.name();
        }
        if (dados.business_branch() != null){
            this.business_branch = dados.business_branch();
        }
        if (dados.founding_yeans() != null){
            this.founding_yeans = dados.founding_yeans();
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}
