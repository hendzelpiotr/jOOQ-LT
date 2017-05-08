package com.pgs.soft.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by phendzel on 5/5/2017.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    /*
      To use h2 database - please uncomment the following code
     */
    /*@Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }*/

}
