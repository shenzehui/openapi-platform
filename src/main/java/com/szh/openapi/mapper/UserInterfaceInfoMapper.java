package com.szh.openapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szh.openapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * @author ASUS
 * @description 针对表【user_interface_info(接口用户关联表)】的数据库操作Mapper
 * @createDate 2023-04-22 16:39:21
 * @Entity com.szh.openapi.model.entity.UserInterfaceInfo
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




