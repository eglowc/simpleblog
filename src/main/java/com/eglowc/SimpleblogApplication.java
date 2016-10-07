package com.eglowc;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {SimpleblogApplication.class, Jsr310JpaConverters.class} )
public class SimpleblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleblogApplication.class, args);
	}

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
