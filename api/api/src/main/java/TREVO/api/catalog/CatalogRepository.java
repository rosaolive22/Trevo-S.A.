package TREVO.api.catalog;

import TREVO.api.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog,Integer> {
    Page<Catalog> findAllByAtivoTrue(Pageable paginacao);
}
