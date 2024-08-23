package ceing.ceing.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter(AccessLevel.PRIVATE)
public class ItemSize {//한 상품은 여러 상품 사이즈를 가질 수 있다. 한 사이즈는 한 상품에게만 할당됨

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name; //사이즈 이름

  private int fullLength; //총장

  private int shoulderWidth; //어깨 너비

  private int chestLength; //가슴 단면

  private int sleeveLength;

  //한 사이즈는 한 옷에게만 종속되고, 한 옷은 여러 사이즈를 갖는다
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Item item;


}
