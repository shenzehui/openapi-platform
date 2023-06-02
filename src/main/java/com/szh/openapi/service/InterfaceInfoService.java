package com.szh.openapi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.szh.openapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.szh.openapicommon.model.entity.InterfaceInfo;

/**
 * @author ASUS
 * @description 针对表【interface_info(openapi.`interface_info`)】的数据库操作Service
 * @createDate 2023-04-20 15:18:18
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);
}
