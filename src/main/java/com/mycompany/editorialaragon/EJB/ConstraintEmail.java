/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.EJB;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 *
 * @author LUIS
 */
@Documented
@Pattern.List({@Pattern(regexp="^(.+)@(.+)$")})
@Constraint(validatedBy ={})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstraintEmail {

    String message() default "{com.mycompany.editorialaragon.EJB.ConstraintEmail}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
