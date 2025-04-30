package org.kuroneko.starpivot.services;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.kuroneko.starpivot.config.GlobalConfig;
import org.kuroneko.starpivot.entity.Configuration;
import org.kuroneko.starpivot.utils.ConfigurationOperator;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HadoopConfigurationService {

    Logger logger = LoggerFactory.getLogger(HadoopConfigurationService.class);
    private final GlobalConfig globalConfig;
    @Autowired
    public HadoopConfigurationService(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    public void setupCoreSite(List<Configuration> configurations)
            throws DocumentException {
        for (Configuration configuration : configurations) {
            ConfigurationOperator configurationOperator =
                    new ConfigurationOperator(globalConfig.getCoreSiteUrl());
            Element property = configurationOperator.findProperty(configuration.getName());
            if (property == null) {
                configurationOperator.addProperty(
                        configuration.getName(),
                        configuration.getValue(),
                        configuration.getDescription()
                );
            }else {
                property.setText(configuration.getValue());
            }
        }
    }
}
