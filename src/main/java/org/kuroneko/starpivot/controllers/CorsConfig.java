package org.kuroneko.starpivot.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig 是一个 Spring 配置类，用于配置跨域资源共享（CORS）策略。
 * 跨域资源共享是一种允许浏览器在跨域请求时访问资源的机制，该配置类确保前端应用能够与后端服务进行跨域通信。
 * 通过此配置，我们可以精确控制哪些域名、请求方法、请求头以及认证信息可以被允许跨域访问后端接口，增强系统的安全性和兼容性。
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 重写 WebMvcConfigurer 接口的 addCorsMappings 方法，用于配置跨域映射规则。
     * 该方法定义了哪些路径可以进行跨域请求，以及针对这些请求的详细 CORS 策略。
     *
     * @param registry 用于注册跨域映射规则的 CorsRegistry 对象。
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许所有路径进行跨域请求，即任何后端接口都支持跨域访问
        registry.addMapping("/**")
                // 仅允许来自 "http://localhost:5173" 域名的跨域请求，增强安全性，防止其他不明来源的跨域访问
                .allowedOrigins("http://localhost:5173")
                // 允许请求携带认证信息，如 cookie、HTTP 认证等，前后端需保持一致的配置
                .allowCredentials(true)
                // 设置预检请求（OPTIONS 请求）的缓存时间为 3600 秒（即 1 小时），减少不必要的预检请求，提高性能
                .maxAge(3600)
                // 允许所有的请求头，确保前端可以使用各种自定义请求头与后端进行通信
                .allowedHeaders("*")
                // 允许的 HTTP 请求方法，包括 GET、POST、PUT 和 DELETE，满足常见的增删改查操作需求
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}