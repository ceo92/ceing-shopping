package ceing.ceing.web.login;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberSaveDto {
    @NotBlank
    private String username;

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;

}
