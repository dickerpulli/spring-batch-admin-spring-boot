package de.codecentric.batch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * To start SpringBatchAdmin you need to import these 2 files:
 *  - /org/springframework/batch/admin/web/resources/servlet-config.xml (spring-batch-admin-resources-1.3.0.RELEASE.jar)
 *  - /org/springframework/batch/admin/web/resources/webapp-config.xml (spring-batch-admin-resources-1.3.0.RELEASE.jar)
 *
 * And you can import it as is done in MainV1Configuration.class
 * 
 * But if you want to customise the app a little more (like import your own properties files) you will get the following error:
 * java.lang.IllegalArgumentException: Could not resolve placeholder 'xxx' in string value "${xxx}"
 * 
 * As inside "/META-INF/spring/batch/bootstrap/manager/env-context.xml (spring-batch-admin-manager-1.3.1.RELEASE.jar)" 
 * there is defined a PlaceHolder
 * 
 * Use this configuration version if you want to overwrite the placeholder
 * 
 * @author Abel ANEIROS
 */
@Configuration
@ImportResource({
    /*
     * classpath:/org/springframework/batch/admin/web/resources/servlet-config.xml imports by default:
     *  - spring-batch-admin-manager-1.3.0.RELEASE.jar!/META-INF/spring/batch/servlet/manager/controller-context.xml
     *  - spring-batch-admin-manager-1.3.0.RELEASE.jar!/META-INF/spring/batch/servlet/manager/integration-context.xml
     *  - spring-batch-admin-resources-1.3.0.RELEASE.jar!/META-INF/spring/batch/servlet/resources/resources-context.xml
     *  - spring-batch-admin-manager-1.3.0.RELEASE.jar!/META-INF/spring/batch/servlet/manager/manager-context.xml
     */
    "classpath:/org/springframework/batch/admin/web/resources/servlet-config.xml",

    /*
     * classpath:/org/springframework/batch/admin/web/resources/webapp-config.xml imports by default:
     *  - /META-INF/spring/batch/bootstrap/integration/configuration-context.xml", 
     *  - /META-INF/spring/batch/bootstrap/integration/file-context.xml",
     *  - /META-INF/spring/batch/bootstrap/integration/jmx-context.xml",
     *  - /META-INF/spring/batch/bootstrap/integration/launcher-context.xml",
     *  - /META-INF/spring/batch/bootstrap/integration/restart-context.xml",
     *  - /META-INF/spring/batch/bootstrap/manager/data-source-context.xml",
     *  - spring-batch-admin-manager-1.3.0.RELEASE.jar!/META-INF/spring/batch/bootstrap/manager/env-context.xml", (this file contains the place holder)
     *  - /META-INF/spring/batch/bootstrap/manager/execution-context.xml",
     *  - /META-INF/spring/batch/bootstrap/resources/resources-context.xml",
     *  - /META-INF/spring/batch/override/servlet/manager/integration-context.xml"
     */
    
    "classpath*:/META-INF/spring/batch/bootstrap/integration/configuration-context.xml", // spring.integration.default.properties
    "classpath*:/META-INF/spring/batch/bootstrap/integration/file-context.xml",
    //"classpath*:/META-INF/spring/batch/bootstrap/manager/jmx-context.xml",
    "classpath*:/META-INF/spring/batch/bootstrap/integration/launcher-context.xml",
    "classpath*:/META-INF/spring/batch/bootstrap/integration/restart-context.xml",
    "classpath*:/META-INF/spring/batch/bootstrap/manager/data-source-context.xml",
    //"classpath*:/META-INF/spring/batch/bootstrap/manager/env-context.xml",
    "classpath*:/META-INF/spring/batch/bootstrap/manager/execution-context.xml",
    "classpath*:/META-INF/spring/batch/bootstrap/resources/resources-context.xml",
    "classpath*:/META-INF/spring/batch/override/servlet/manager/integration-context.xml"

    })
public class MainV2Configuration {
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() { 
        
        Resource[] resources = {
            new ClassPathResource("batch-hsql.properties"),
            new ClassPathResource("your-properties.properties")
        };
        
        PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
        bean.setLocations(resources);
         
        return bean; 
    } 
}