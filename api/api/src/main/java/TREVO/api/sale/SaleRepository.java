package TREVO.api.sale;

import TREVO.api.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {
    Page<Product> findAllByAtivoTrue(Pageable paginacao);
}
