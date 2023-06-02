package com.szh.openapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.szh.openapi.annotation.AuthCheck;
import com.szh.openapi.common.BaseResponse;
import com.szh.openapi.common.ErrorCode;
import com.szh.openapi.common.ResultUtils;
import com.szh.openapi.constant.UserConstant;
import com.szh.openapi.exception.BusinessException;
import com.szh.openapi.mapper.UserInterfaceInfoMapper;
import com.szh.openapi.model.vo.InterfaceInfoVO;
import com.szh.openapi.service.InterfaceInfoService;
import com.szh.openapicommon.model.entity.InterfaceInfo;
import com.szh.openapicommon.model.entity.UserInterfaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分析控制器
 * Created by szh on 2023-04-25
 */

@RestController
@Slf4j
@RequestMapping("/analysis")
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo() {
        List<UserInterfaceInfo> listUserInterfaceInfo = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = listUserInterfaceInfo.stream().collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        Set<Long> set = interfaceInfoIdObjMap.keySet();
        queryWrapper.lambda().in(InterfaceInfo::getId, set);
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            int totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(interfaceInfoVOList);
    }
}