package ceing.ceing.web.constraintannotation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NoBlankValidator.class)
@Target({ElementType.PARAMETER, ElementType.METHOD , ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface NoBlank {
  String message() default "값을 채워주세요"; //유효성 검사 false 시 반환되는 디폴트 메시지

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
