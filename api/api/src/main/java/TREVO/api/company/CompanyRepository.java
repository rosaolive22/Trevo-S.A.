package TREVO.api.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Page<Company> findAllByAtivoTrue(Pageable paginacao);
    Company getReferenceById(Long id);
}
