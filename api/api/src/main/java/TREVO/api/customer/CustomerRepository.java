package TREVO.api.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Order,Long> {
    Order getReferenceById(Long cod);
}
