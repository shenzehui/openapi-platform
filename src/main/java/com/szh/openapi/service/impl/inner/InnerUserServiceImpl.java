package com.szh.openapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.szh.openapi.common.ErrorCode;
import com.szh.openapi.exception.BusinessException;
import com.szh.openapi.mapper.UserMapper;
import com.szh.openapicommon.model.entity.User;
import com.szh.openapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * Created by szh on 2023-04-25
 */

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
