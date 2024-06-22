package ceing.ceing.web.dto;

import ceing.ceing.domain.Address;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * 회원가입 DTO
 */

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

    @Embedded
    @Valid
    private Address address;

    @NotBlank(message = "전화번호")
    private String phoneNumber;

}
