package ceing.ceing.web.login;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class LoginDto {

    @NotBlank(message = "아이디는 필수입니다.")
    private String loginId;
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    public LoginDto(){}
    public LoginDto(String loginId , String password){
        this.loginId=loginId;
        this.password = password;
    }


}
