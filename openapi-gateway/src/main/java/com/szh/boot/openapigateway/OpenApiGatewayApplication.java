package com.szh.boot.openapigateway;

import com.szh.boot.openapigateway.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author szh
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubbo
@Service
public class OpenApiGatewayApplication {

    @DubboReference(check = false)
    private DemoService demoService;

    public static void main(String[] args) {
        System.setProperty("user.home", "myhome");
        ConfigurableApplicationContext context = SpringApplication.run(OpenApiGatewayApplication.class, args);
        OpenApiGatewayApplication application = context.getBean(OpenApiGatewayApplication.class);
        String result = application.doSayHello("world");
        System.out.println(result);
    }

    private String doSayHello(String text) {
        return demoService.sayHello(text);
    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes().route("to_baidu", r -> r.path("/baidu").uri("http://www.baidu.com/")).build();
//    }

    @Bean
    public CustomGlobalFilter customGlobalFilter() {
        return new CustomGlobalFilter();
    }

}
