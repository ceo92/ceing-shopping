package ceing.ceing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class DiscountPolicy {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "discount_policy_id")
  private Long id;

  //쿠폰 , 포인트??



}
