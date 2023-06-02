package com.szh.openapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.szh.openapi.exception.BusinessException;
import com.szh.openapi.common.ErrorCode;
import com.szh.openapi.mapper.InterfaceInfoMapper;
import com.szh.openapicommon.model.entity.InterfaceInfo;
import com.szh.openapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * Created by szh on 2023-04-25
 */

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
