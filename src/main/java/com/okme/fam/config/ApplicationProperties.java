package com.okme.fam.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to Okme.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private String urlSSO;
    private String https;

    public String getUrlSSO() {
        return urlSSO;
    }

    public void setUrlSSO(String urlSSO) {
        this.urlSSO = urlSSO;
    }

    public String getHttps() {
        return https;
    }

    public void setHttps(String https) {
        this.https = https;
    }

    public ApplicationProperties() {
    }

    public ApplicationProperties(String urlSSO, String https) {
        this.urlSSO = urlSSO;
        this.https = https;
    }
}
