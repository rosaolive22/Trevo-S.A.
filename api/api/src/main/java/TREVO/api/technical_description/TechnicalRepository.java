package TREVO.api.technical_description;

import TREVO.api.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalRepository extends JpaRepository<Technical_description,Long> {
    Page<Technical_description> findAllByAtivoTrue(Pageable paginacao);

}
