package de.tbosch.spring.batch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ServletConfiguration.class, WebappConfiguration.class })
public class MainConfiguration {

}
