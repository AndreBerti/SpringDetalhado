package com.tekila.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tekila.repository.AnimalConfig;

@Configuration
public class Animal {

	@Bean(name="cachorro")
	public AnimalConfig cachorro() {
		return new AnimalConfig(){
			@Override
			public void fazerBarulho() {
				System.out.println("au au");
			} 
		};
	}

	@Bean(name="gato")
	public AnimalConfig gato() {
		return new AnimalConfig(){	
			@Override
			public void fazerBarulho() {
				System.out.println("maiu");
			}
		};
	}
}
