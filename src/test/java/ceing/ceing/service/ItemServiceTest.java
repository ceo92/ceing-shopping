package ceing.ceing.service;


import ceing.ceing.domain.Item;
import ceing.ceing.domain.ItemSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ItemServiceTest {

  @Autowired private ItemService itemService;

  @Test
  void findItems() {
    //given
    Item item = new Item();
    //when
    itemService.saveItem();
    //then


  }
}