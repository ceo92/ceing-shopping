package ceing.ceing.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter(AccessLevel.PRIVATE)
public class ItemSize {

  @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
  @Column(name = "item_size_id")
  private Long id;

  //일단 단방향 연관관계 ㅇㅇ 추후 양방향 연관관계는 그냥 조회용 리스트 객체 하나만 추가하면 되므로 !

  @Enumerated(EnumType.STRING)
  private SizeConst size;
  //한 상품(1)은 여러 사이즈 가짐 , 한 사이즈는 한 상품에게만 할다 ,
  //Member과 Team은 한 팀에 여러 멤버들이 속하므로 멤버가 N이고 Team이 1 , 내가 어떤 설계를 통해 기능분석을 해서 서비스를 만들었는지를 산출물로 내야됨
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id") //
  private Item item;




}
