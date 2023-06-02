package com.szh.openapicommon.service;

import com.szh.openapicommon.model.entity.InterfaceInfo;

/**
 * @author ASUS
 * @description 针对表【user_interface_info(接口用户关联表)】的数据库操作Service
 * @createDate 2023-04-22 16:39:21
 */
public interface InnerInterfaceInfoService {


    /**
     * 从数据库中查询接口是否存在
     *
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);


}
