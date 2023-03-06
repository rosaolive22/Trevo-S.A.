package TREVO.api.technical_description;

import jakarta.validation.constraints.NotBlank;

public record DadosTechnical(Long cod,
                             @NotBlank
                              String indicated_technical) {
}
