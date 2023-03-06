package TREVO.api.catalog;

import jakarta.validation.constraints.NotBlank;

public record ONCatalog(
        Integer cod,
        Integer id_product,
        Culture culture,
        Long id_company) {
}
