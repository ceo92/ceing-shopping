package ceing.ceing.repository;

import ceing.ceing.domain.Brand;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class BrandRepository {

  private final EntityManager em;

  @Transactional
  public Long save(Brand brand) {
    em.persist(brand);
    return brand.getId();
  }

  public Optional<Brand> findById(Long id) {
    return Optional.ofNullable(em.find(Brand.class, id));
  }

  public List<Brand> findAll() {
    String jpql = "select b from Brand b";
    return em.createQuery(jpql, Brand.class).getResultList();
  }


}
