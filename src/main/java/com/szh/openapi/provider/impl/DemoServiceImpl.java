package com.szh.openapi.provider.impl;

import com.szh.openapi.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author ASUS
 */

@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
