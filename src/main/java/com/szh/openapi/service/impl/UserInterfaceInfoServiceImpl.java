package com.szh.openapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szh.openapi.exception.BusinessException;
import com.szh.openapi.exception.ThrowUtils;
import com.szh.openapi.mapper.UserInterfaceInfoMapper;
import com.szh.openapi.common.ErrorCode;
import com.szh.openapi.constant.CommonConstant;
import com.szh.openapi.service.UserInterfaceInfoService;
import com.szh.openapi.utils.SqlUtils;
import com.szh.openapicommon.model.entity.UserInterfaceInfo;
import com.szh.openapicommon.model.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ASUS
 * @description 针对表【user_interface_info(接口用户关联表)】的数据库操作Service实现
 * @createDate 2023-04-22 16:39:21
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo> implements UserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest) {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (userInterfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        Long id = userInterfaceInfoQueryRequest.getId();
        Long userId = userInterfaceInfoQueryRequest.getUserId();
        Long interfaceInfoId = userInterfaceInfoQueryRequest.getInterfaceInfoId();
        Integer status = userInterfaceInfoQueryRequest.getStatus();
        String sortField = userInterfaceInfoQueryRequest.getSortField();
        String sortOrder = userInterfaceInfoQueryRequest.getSortOrder();

        // 拼接查询条件
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "interfaceInfoId", interfaceInfoId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(status), "status", status);
        queryWrapper.eq("isDeleted", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        return queryWrapper;
    }

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Long userId = userInterfaceInfo.getUserId();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(ObjectUtils.isEmpty(interfaceInfoId) || interfaceInfoId <= 0 || userId <= 0, ErrorCode.PARAMS_ERROR);
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口剩余次数不能小于0");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 参数校验
        ThrowUtils.throwIf(interfaceInfoId <= 0 || userId <= 0, ErrorCode.PARAMS_ERROR);
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.setSql("leftNum = leftNum -1,totalNum = totalNum + 1");
        // leftNum > 0
        updateWrapper.gt("leftNum", 0);
        return this.update(updateWrapper);
    }
}




