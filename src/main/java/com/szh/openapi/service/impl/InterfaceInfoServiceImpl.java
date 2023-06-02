package com.szh.openapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szh.openapi.common.ErrorCode;
import com.szh.openapi.constant.CommonConstant;
import com.szh.openapi.exception.BusinessException;
import com.szh.openapi.exception.ThrowUtils;
import com.szh.openapi.mapper.InterfaceInfoMapper;
import com.szh.openapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.szh.openapi.service.InterfaceInfoService;
import com.szh.openapi.utils.SqlUtils;
import com.szh.openapicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author ASUS
 * @description 针对表【interface_info(openapi.`interface_info`)】的数据库操作Service实现
 * @createDate 2023-04-20 15:18:18
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo> implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }

    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (interfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        Long id = interfaceInfoQueryRequest.getId();
        String name = interfaceInfoQueryRequest.getName();
        String description = interfaceInfoQueryRequest.getDescription();
        String url = interfaceInfoQueryRequest.getUrl();
        String requestParams = interfaceInfoQueryRequest.getRequestParams();
        String requestHeader = interfaceInfoQueryRequest.getRequestHeader();
        String responseHeader = interfaceInfoQueryRequest.getResponseHeader();
        Integer status = interfaceInfoQueryRequest.getStatus();
        String method = interfaceInfoQueryRequest.getMethod();
        Long userId = interfaceInfoQueryRequest.getUserId();
        String sortField = interfaceInfoQueryRequest.getSortField();
        String sortOrder = interfaceInfoQueryRequest.getSortOrder();
        // 拼接查询条件
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        queryWrapper.like(StringUtils.isNotBlank(description), "description", description);
        queryWrapper.like(StringUtils.isNotBlank(url), "url", url);
        queryWrapper.like(StringUtils.isNotBlank(requestParams), "requestParams", requestParams);
        queryWrapper.like(StringUtils.isNotBlank(requestHeader), "requestHeader", requestHeader);
        queryWrapper.like(StringUtils.isNotBlank(responseHeader), "responseHeader", responseHeader);
        queryWrapper.eq(StringUtils.isNotBlank(method), "method", method);
        queryWrapper.eq(ObjectUtils.isNotEmpty(status), "status", status);
        queryWrapper.eq(ObjectUtils.isNotEmpty(id), "id", id);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq("isDeleted", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        return queryWrapper;
    }
}




