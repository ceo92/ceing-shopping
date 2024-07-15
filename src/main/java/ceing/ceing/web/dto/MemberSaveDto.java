package ceing.ceing.web.dto;

import ceing.ceing.web.constraintannotation.validation.NoBlank;
import lombok.Getter;
import lombok.Setter;

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
