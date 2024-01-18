package com.tekila.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


/* Atençao ElementType.FIELD*/
@Target(ElementType.FIELD)
@Retention (RetentionPolicy.RUNTIME)
@Autowired
@Qualifier("gato")
public @interface Gato {

}
