package TREVO.api.image;

import TREVO.api.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
    Page<Image> findAllByAtivoTrue(Pageable paginacao);
}
