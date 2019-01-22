package com.user.system.usersystem.annotations;


import com.user.system.usersystem.validators.PictureConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PictureConstraintValidator.class)
@Target({METHOD,FIELD})
@Retention(RUNTIME)
public @interface Picture {
    String message() default "Invalid Picture";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
