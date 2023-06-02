package com.szh.openapi.service.impl.inner;

import com.szh.openapi.service.UserInterfaceInfoService;
import com.szh.openapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * Created by szh on 2023-04-25
 */

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

}
