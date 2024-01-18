package com.tekila.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/*@configuration para dizer que é uma condiguraçao
 *@profile para dizer que so vai rodar se a aplicação ativa for o development
 *++++++++++++++++
 *@Target(ElementType.TYPE)
  @Retention(RetentionPolicy.RUNTIME)
 *Sao sempre usadas quando voce cria uma annotation
 *o elementtype.type diz que voce so pode usar isso em uma classe
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Profile("development")

public @interface Development {

}