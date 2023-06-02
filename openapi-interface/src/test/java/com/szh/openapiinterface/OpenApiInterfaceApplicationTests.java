package com.szh.openapiinterface;

import com.szh.openapiclientsdk.client.OpenApiClient;
import com.szh.openapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class OpenApiInterfaceApplicationTests {

    @Resource
    private OpenApiClient openApiClient;

    @Test
    void contextLoads() {
        String szh = openApiClient.getNameByGet("szh");
        String szh1 = openApiClient.getNameByPost("szh");
        User user = new User();
        user.setUsername("szh");
        openApiClient.getUserNameByPost(user);
    }

}
