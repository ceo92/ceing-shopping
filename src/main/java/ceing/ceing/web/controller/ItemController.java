package ceing.ceing.web.controller;

import ceing.ceing.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemSerivce;

  /**
   * 상품 목록
   */

  @GetMapping("items")
  public String aa(){
    return "item/items";
  }



  /**
   * 상품
   */
  @GetMapping("item")
  public String xx(){
    return "item/item";
  }



}
