package ceing.ceing.repository;


import ceing.ceing.domain.Color;
import ceing.ceing.domain.Item;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

  private final EntityManager em;
  private final JPAQueryFactory query;

  @Autowired
  public ItemRepository(EntityManager em) {
    this.em = em;
    this.query = new JPAQueryFactory(em);
  }

  // Item 등록 , 관리자 권한
  public Long save(Item item){
    em.persist(item);
    return item.getId();
  }

  // Item 조회 , 일대다 다대일
  public Optional<Item> findById(Long id){
    return Optional.ofNullable(em.find(Item.class, id));
  }

  public List<Item> findAll(){
    String jpql = "select i from Item i join fetch i.itemSizes"; //JPQL은 객체에 날리는 것 , 이렇게 페치 조인을 통해 가져와서 명령어로 하는 것
    return em.createQuery(jpql, Item.class).getResultList();
  }





}
