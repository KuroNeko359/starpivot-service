package org.kuroneko.starpivot.controllers;


import org.kuroneko.starpivot.entity.memory.MemoryInfoDTO;
import org.kuroneko.starpivot.monitor.MemoryMonitor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MemoryController 是一个 Spring 框架的 RESTful 控制器，负责处理与系统内存信息相关的 HTTP 请求。
 * 该控制器通过调用 MemoryMonitor 类来获取系统的内存使用信息，并将其以 JSON 格式返回给客户端，
 * 主要用于向外部提供系统内存状态的查询接口，方便监控和管理系统资源。
 */
@RestController
public class MemoryController {

    /**
     * 处理 HTTP GET 请求，请求路径为 "/system/resource/memory"。
     * 此方法会调用 MemoryMonitor 类的 getMemory 方法来获取系统的内存使用信息，
     * 包括 JVM 内存和系统内存的详细情况，并将这些信息封装在 MemoryInfoDTO 对象中返回。
     * 客户端可以通过该接口获取系统当前的内存状态，用于监控和分析系统的资源使用情况。
     *
     * @return 一个 MemoryInfoDTO 对象，包含 JVM 内存和系统内存的使用信息。
     *         该对象会被 Spring 框架自动转换为 JSON 格式返回给客户端。
     */
    @GetMapping("/system/resource/memory")
    public MemoryInfoDTO getMemoryFree() {
        // 创建 MemoryMonitor 实例并调用其 getMemory 方法获取内存信息
        return new MemoryMonitor().getMemory();
    }
}