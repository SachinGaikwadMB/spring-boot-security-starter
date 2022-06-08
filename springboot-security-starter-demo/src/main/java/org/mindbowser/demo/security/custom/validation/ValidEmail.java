package org.mindbowser.demo.security.custom.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.TYPE_USE})
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {
	String message() default "Please try to login with your organization email address";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}