package org.kuroneko.starpivot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.global")
public class GlobalConfig {
    private String hadoopUrl;

    public String getHadoopUrl() {
        return hadoopUrl;
    }

    public void setHadoopUrl(String hadoopUrl) {
        this.hadoopUrl = hadoopUrl;
    }
}
