package TREVO.api.technical_description;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "technical_description")
@Entity(name = "Technical_description")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cod")

public class Technical_description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;
    @NotBlank
    private String indicated_technical;
    private Boolean ativo;
    public Technical_description(DadosTechnical dados) {
        this.cod = dados.cod();
        this.indicated_technical = dados.indicated_technical();
        this.ativo = true;
    }
    public void atualizar(DadosTechnical dados) {
        if (dados.indicated_technical() != null) {
            this.indicated_technical = dados.indicated_technical();
        }
    }
    public void excluir() {
        this.ativo = false;
    }
}
