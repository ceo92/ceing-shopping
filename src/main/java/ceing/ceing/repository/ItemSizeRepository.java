package ceing.ceing.repository;

import ceing.ceing.domain.ItemSize;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemSizeRepository {
  private final EntityManager em;

  public Long save(ItemSize itemSize){
    em.persist(itemSize);
    return itemSize.getId();
  }

}