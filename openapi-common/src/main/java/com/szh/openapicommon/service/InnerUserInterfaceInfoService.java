package com.szh.openapicommon.service;

/**
 * Created by szh on 2023-04-25
 */

public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     *
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

}
