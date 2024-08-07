package ceing.ceing.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode //값 타입 비교 시 인스턴스 주소가 아닌 실제 내부 값에 의한 비교를 위하여 ㅇㅇ
public class Address {
  private String roadNameAddress;
  private String zipCode;

  public Address(String roadNameAddress, String zipCode) {
    this.roadNameAddress = roadNameAddress;
    this.zipCode = zipCode;
  }

  protected Address(){}
}
