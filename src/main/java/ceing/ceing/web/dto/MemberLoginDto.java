package ceing.ceing.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class MemberLoginDto {
  @NotBlank(message = "아이디는 필수입니다.")
  private String loginId;
  @NotBlank(message = "비밀번호는 필수입니다.")
  private String password;


  public MemberLoginDto(){}
  public MemberLoginDto(String loginId , String password){
    this.loginId=loginId;
    this.password = password;
  }


}
