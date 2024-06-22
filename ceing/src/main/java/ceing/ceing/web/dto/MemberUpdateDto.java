package ceing.ceing.web.dto;

import ceing.ceing.domain.Address;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberUpdateDto {

  @NotBlank(message = "이름")
  private String username;

  @NotBlank(message = "주소")
  @Embedded
  private Address address;

  @NotBlank(message = "전화번호")
  private String phoneNumber;
}
