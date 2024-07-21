package ceing.ceing.web.controller;

import ceing.ceing.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemSerivce;

  /**
   * 상품 목록
   */

  @GetMapping("items")
  public String items(Model model){
    return "item/items";
  }


  @PostMapping("items")
  public String items(){

  }


  /**
   * 상품
   */
  @GetMapping("items/{id}")
  public String item(){
    return "item/item";
  }

  @PostMapping("items/{id}")
  public String item(@PathVariable("id")Long id , @ModelAttribute){

    return "item/item";
  }



}
