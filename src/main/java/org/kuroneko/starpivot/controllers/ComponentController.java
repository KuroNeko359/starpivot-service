package org.kuroneko.starpivot.controllers;

import org.kuroneko.starpivot.entity.Component;
import org.kuroneko.starpivot.services.ComponentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("components")
public class ComponentController {
    private final ComponentService componentService;

    public ComponentController(ComponentService componentService) {
        this.componentService = componentService;
    }

    @GetMapping("hadoop")
    public Component getHadoopComponent() {
        return componentService.findByName("hadoop");
    }
}
