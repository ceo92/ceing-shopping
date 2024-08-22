package ceing.ceing.domain;

import jakarta.persistence.Column;
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

@Entity
@Getter @Setter(AccessLevel.PRIVATE)
public class Color {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "color_id")
  private Long id;

  private String name;

  //한 옷은 여러 색깔을 가질 수 있고, 한 색깔은 한 옷에게만 할당됨
  //한 팀은 여러 멤버를 가질 수 있음 , 이때 Member이 연관관계 주인이 됨 , 즉 참조키도 갖게 됨
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Item item;

}
