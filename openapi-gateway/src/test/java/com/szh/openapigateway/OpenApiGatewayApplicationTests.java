package com.szh.openapigateway;

import com.szh.boot.openapigateway.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenApiGatewayApplicationTests {

    @DubboReference
    private DemoService demoService;

    /**
     * 远程调用测试
     */
    @Test
    void testRpc() {
        System.out.println(demoService.sayHello("world"));
    }

}
