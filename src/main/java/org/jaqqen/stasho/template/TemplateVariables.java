package org.jaqqen.stasho.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties(prefix = "template.custom.variables")
public class TemplateVariables {
    private final static Logger LOG = LoggerFactory.getLogger(TemplateVariables.class);
    private String logout;

    @PostConstruct
    private void init() {}

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }
}
