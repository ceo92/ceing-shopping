package ceing.ceing.repository;

import ceing.ceing.domain.Color;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ColorRepository {
  private final EntityManager em;

  public Long save(Color color){
    em.persist(color);
    return color.getId();
  }

}
