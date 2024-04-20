package ceing.ceing.repository;


import ceing.ceing.domain.Item;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
@RequiredArgsConstructor
public class ItemRepositoryImplJpa {

    private final EntityManager em;
    public Item save(Item item){
        em.persist(item);
        return item;
    }

    public void update(Long itemId , Item item){
        Item findItem = findById(itemId).orElseThrow();
        findItem.setItemName(item.getItemName());
        findItem.setPrice(item.getPrice());
        findItem.setQuantity(item.getQuantity());
    }

    public Optional<Item> findById(Long itemId){
        return Optional.ofNullable(em.find(Item.class , itemId));
    }

    public List<Item> findAll(){
        String jpql = "select i from i Item";
        return em.createQuery(jpql).getResultList();
    }


}
