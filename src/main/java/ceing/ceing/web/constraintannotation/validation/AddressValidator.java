package ceing.ceing.web.constraintannotation.validation;

import ceing.ceing.domain.Address;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class AddressValidator implements ConstraintValidator<NotBlankAddress , Address> {

  @Override
  public void initialize(NotBlankAddress constraintAnnotation) {
  }

  @Override
  public boolean isValid(Address address, ConstraintValidatorContext validatorContext) {
    validatorContext.disableDefaultConstraintViolation();//이걸 통해 어노테이션 기본 메시지 제거하자 , 기본 메시지 + 에러 메시지로 전달되니

    if (!(StringUtils.hasText(address.getZipCode()) || StringUtils.hasText(address.getRoadNameAddress()))){
      validatorContext.buildConstraintViolationWithTemplate("주소 값은 필수여야 합니다")
          .addConstraintViolation();
      return false; //MethodArgumentNotValidException 터짐
    }
    return true;
  }
}
