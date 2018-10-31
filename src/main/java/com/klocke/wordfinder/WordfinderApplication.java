package com.klocke.wordfinder;

import com.klocke.wordfinder.database.data.WordGrid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.sql.Connection;
import java.sql.DriverManager;

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
