/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajadores.EJB;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author LUIS
 */
@Documented
@Pattern.List({@Pattern(regexp="*([a-zA-Z0-9]{4,20})*$")})
@Constraint(validatedBy ={})
@NotNull
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstraintUsuario {

    String message() default "{com.mycompany.trabajadores.ConstraintUsuario}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
