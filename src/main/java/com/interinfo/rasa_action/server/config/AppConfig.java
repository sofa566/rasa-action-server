package com.interinfo.rasa_action.server.config;

import io.github.rbajek.rasa.sdk.ActionExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rafał Bajek
 */
@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = "com.interinfo.rasa_action.server")
public class AppConfig {

    @Bean
    public ActionExecutor rasaActionExecutor() {
        return new ActionExecutor();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
