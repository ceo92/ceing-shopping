package ceing.ceing.service;

import ceing.ceing.domain.Item;
import ceing.ceing.repository.ItemRepository;
import ceing.ceing.web.dto.ItemSaveDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  //OSRF 때문에 밖에서도 영속성 관리가 되긴 함 , 그래서 LazyException이 안 터지고 지연 로딩이 가능
  public List<Item> findItems() { //findAll : OSIV가 꺼져있을 경우 전체를 가져오는 것이니 트랜잭션 범위를 벗어나도 조회가 잘 되나?
    return itemRepository.findAll();
  }


  public Item findItem(Long id){
    return itemRepository.findById(id).orElse(null);
  }

  @Transactional
  public void saveItem(Item item){
    itemRepository.save(item);
  }






}

