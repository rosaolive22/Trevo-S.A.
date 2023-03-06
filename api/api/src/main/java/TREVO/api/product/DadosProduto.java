package TREVO.api.product;

import TREVO.api.catalog.Culture;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

public record DadosProduto(
        Long id_product,
        @NotBlank
        String name,
        @NotBlank
        String size,
        @NotNull
        Boolean status,
        LocalDate date_register,
        URL img,
         //Estudar sobre lista de catalog
        Integer id_catalog,
         //Estudar sobre lista de catalog
        Culture culture) {

}
