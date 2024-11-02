package org.example.ajirkacustomersupport2.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
@Configuration
@ComponentScan(basePackages = "org.example.ajirkacustomersupport2.site",
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootContextConfig {
}