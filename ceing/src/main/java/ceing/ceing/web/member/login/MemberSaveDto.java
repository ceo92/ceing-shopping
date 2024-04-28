package ceing.ceing.web.member.login;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberSaveDto {
    @NotBlank(message = "이름")
    private String username;

    @NotBlank(message = "아이디")
    private String loginId;

    @NotBlank(message = "비밀번호")
    private String password;

    @NotBlank
    private String rePassword;

    @NotBlank(message = "주소")
    private String address;

    @NotBlank(message = "전화번호")
    private String phoneNumber;

}
