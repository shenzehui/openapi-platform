package com.szh.openapi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.szh.openapicommon.model.entity.UserInterfaceInfo;
import com.szh.openapicommon.model.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;

/**
 * Created by szh on 2023-04-25
 */

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest);

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     *
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
