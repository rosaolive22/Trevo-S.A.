package TREVO.api.company;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCompany(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @NotBlank
        //@Pattern(regexp = "\\d{14}")
        String cnpj,
        @NotBlank
        @Column(name = "name",unique = true)
        String name,
        String business_branch,
        Integer founding_yeans) {
}
