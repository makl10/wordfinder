package com.klocke.wordfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WordfinderApplication extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicaton)
	{
		return applicaton.sources(WordfinderApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WordfinderApplication.class, args);
	}
}
