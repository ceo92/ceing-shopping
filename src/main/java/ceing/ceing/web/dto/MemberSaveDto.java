package ceing.ceing.web.dto;

import ceing.ceing.domain.Address;
import ceing.ceing.web.constraintannotation.NoBlank;
import ceing.ceing.web.constraintannotation.NotBlankAddress;
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

    @NoBlank
    private String username;

    @NoBlank
    private String loginId;

    @NoBlank
    private String password;

    @NoBlank
    private String rePassword;

    @NoBlank
    private String roadNameAddress;

    @NoBlank
    private String zipCode;

    @NoBlank
    private String phoneNumber;

}
