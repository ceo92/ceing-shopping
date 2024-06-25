package ceing.ceing.web.constraintannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import org.springframework.util.StringUtils;

public class NoBlankValidator implements ConstraintValidator<NoBlank , String> {

  @Override
  public void initialize(NoBlank constraintAnnotation) {
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext context) {
    context.disableDefaultConstraintViolation();

    if (!StringUtils.hasText(s)){
      context.buildConstraintViolationWithTemplate("값을 할당하시지요").addConstraintViolation();
      return false;
    }
    return true;
  }
}
