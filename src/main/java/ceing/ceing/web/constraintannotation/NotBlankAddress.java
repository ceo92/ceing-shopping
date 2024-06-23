package ceing.ceing.web.constraintannotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.beans.factory.annotation.Autowired;

@Documented
@Constraint(validatedBy = AddressValidator.class)
@Target({ElementType.TYPE , ElementType.FIELD , ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlankAddress {
  //이 밑에 세 필드를 선언하는 게 기본 규격 , 정형화된 형식
  String message() default "주소 값을 넣어야합니다 !"; //유효성 검사 false 시 반환되는 디폴트 메시지
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
