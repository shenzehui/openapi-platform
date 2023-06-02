package com.szh.openapi.manager;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Cos 操作测试
 *
 * @author szh
 */
@SpringBootTest
class osManagerTest {

    @Resource
    private CosManager cosManager;

    @Test
    void putObject() {
        cosManager.putObject("test", "test.json");
    }
}