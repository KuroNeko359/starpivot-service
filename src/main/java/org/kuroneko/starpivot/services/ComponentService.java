package org.kuroneko.starpivot.services;

import org.kuroneko.starpivot.entity.Component;
import org.kuroneko.starpivot.repository.ComponentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {
    private final ComponentRepository componentRepository;
    private final Logger logger = LoggerFactory.getLogger(ComponentService.class);
    @Autowired
    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    /**
     * 获取组件列表
     * @return 返回一个组件列表
     */
    public List<Component> findAll() {
        logger.info("Finding all components");
        return componentRepository.findAll();
    }

    /**
     *  根据组件名获取组件
     * @param name 组件名
     * @return 对应的组件
     */
    public Component findByName(String name) {
        return componentRepository.findByName(name).orElseThrow(
                () -> {
                    logger.error("Component with name {} not found", name);
                    return new RuntimeException("Component with name " + name + " not found");
                });
    }
}
