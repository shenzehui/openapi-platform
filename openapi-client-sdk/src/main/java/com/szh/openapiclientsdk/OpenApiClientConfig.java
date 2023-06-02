package com.szh.openapiclientsdk;

import com.szh.openapiclientsdk.client.OpenApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by szh on 2023-04-21
 */

@Configuration
@ConfigurationProperties(prefix = "openapi.client")
@Data
@ComponentScan
public class OpenApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public OpenApiClient openApiClient() {
        return new OpenApiClient(accessKey, secretKey);
    }

}
