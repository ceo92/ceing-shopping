package ceing.ceing.web.controller;

import ceing.ceing.domain.Brand;
import ceing.ceing.domain.Item;
import ceing.ceing.repository.BrandRepository;
import ceing.ceing.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemSerivce;
  private final BrandRepository brandRepository;
  /**
   * 1. 관리자 페이지
   */


  /**
   * 상품 등록 폼
   */
  @GetMapping("items/save")
  public String saveItemForm(Model model){
    model.addAttribute("item", new Item()); //th:field로 폼에 넣기 용
    model.addAttribute("brands", brandRepository.findAll()); //브랜드 리스트로 select box에서 지정용
    return "item/saveItem";
  }


  /*@PostMapping("items/save")
  public String saveItem(){

  }*/

  /**
   * 상품 수정
   */


  /**
   * 2. 사용자 페이지
   */


  /**
   * 상품 목록 조회
   */
  @GetMapping("items")
  public String items(Model model){
    List<Item> items = itemSerivce.findItems(); //items를 서비스가 아닌 프레젠테이션 계층에서 조회하면  , 트랜잭션 주기를 벗어남 , 트랜잭션 주기 벗어나면 영속성 컨텍스트에서도 벗어남 , 벗어나면 변경감지 x 근데 어차피 수정같은 동작 취하려면 서비스에 던질 것이니 조회정도는 ㄱㅊ?
    model.addAttribute("items", items);
    model.addAttribute("itemSizes", ItemSizeConst.values()); //enum
    return "item/items";
  }
  //어차피 jpql은 커밋이 아니라 즉시 flush가 돼서 로딩이 됨 , em.find()로 일부 조회일 경우만
  //로딩이 되어있냐 안 되어있냐


  /**
   * 상품 조회
   */
  @GetMapping("items/{id}")
  public String item(){
    return "item/item";
  }


  /*@PostMapping("items/{id}")
  public String item(@PathVariable("id")Long id , @ModelAttribute){

    return "item/item";
  }*/






}
