/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.codecentric.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import de.codecentric.batch.config.MainConfiguration;

/**
 * Main class to start the Spring Boot application. There are two ways to start it. First: Just run the main method of
 * this class. Second: Create a war file with the spring-boot-maven-plugin and deploy it to tomcat or another servlet
 * container.
 *
 * @author Thomas Bosch
 */
@Configuration
@EnableAutoConfiguration(exclude = { BatchAutoConfiguration.class, DataSourceAutoConfiguration.class,
		WebMvcAutoConfiguration.class })
@Import(MainConfiguration.class)
public class SpringBatchAdmin extends SpringBootServletInitializer {

	/**
	 * Run application.
	 * 
	 * @param args
	 *            Parameters to pass to SpringApplication.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchAdmin.class, args);
	}

	/**
	 * @see org.springframework.boot.context.web.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBatchAdmin.class);
	}

}
