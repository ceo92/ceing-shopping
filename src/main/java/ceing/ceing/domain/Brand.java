package ceing.ceing.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter(AccessLevel.PRIVATE)
public class Brand {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "brand_id")
  private Long id;

  private String brandName;

  private Address address;


  public Brand(String brandName , Address address){
    this.brandName = brandName;
    this.address = address;
  }

  //브랜드는 어떤 상품을 갖는지 조회할 일이 있으므로 이렇게 양방향 연관관계를 하는 게 좋아보임 ㅇㅇ
  @OneToMany(mappedBy = "brand")
  private List<Item> items = new ArrayList<>();






}
