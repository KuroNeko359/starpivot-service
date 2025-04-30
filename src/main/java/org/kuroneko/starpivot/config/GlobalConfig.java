package org.kuroneko.starpivot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.global")
public class GlobalConfig {
    private String hadoopUrl;
    private String starpivotHome;
    private String coreSiteUrl;
    private String hdfsSiteUrl;
    private String yarnSiteUrl;
    private String mapredSiteUrl;

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

    public String getCoreSiteUrl() {
        return coreSiteUrl;
    }

    public void setCoreSiteUrl(String coreSiteUrl) {
        this.coreSiteUrl = coreSiteUrl;
    }

    public String getHdfsSiteUrl() {
        return hdfsSiteUrl;
    }

    public void setHdfsSiteUrl(String hdfsSiteUrl) {
        this.hdfsSiteUrl = hdfsSiteUrl;
    }

    public String getYarnSiteUrl() {
        return yarnSiteUrl;
    }

    public void setYarnSiteUrl(String yarnSiteUrl) {
        this.yarnSiteUrl = yarnSiteUrl;
    }

    public String getMapredSiteUrl() {
        return mapredSiteUrl;
    }

    public void setMapredSiteUrl(String mapredSiteUrl) {
        this.mapredSiteUrl = mapredSiteUrl;
    }
}
