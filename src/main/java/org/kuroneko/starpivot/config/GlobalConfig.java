package org.kuroneko.starpivot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.global")
public class GlobalConfig {
    private String hadoopUrl;
    private String starpivotHome;

    public String getStarpivotHome() {
        return starpivotHome;
    }

    public void setStarpivotHome(String starpivotHome) {
        this.starpivotHome = starpivotHome;
    }

    public String getHadoopUrl() {
        return hadoopUrl;
    }

    public void setHadoopUrl(String hadoopUrl) {
        this.hadoopUrl = hadoopUrl;
    }
}
