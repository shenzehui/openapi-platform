package com.szh.openapicommon.service;

import com.szh.openapicommon.model.entity.User;

/**
 * Created by szh on 2023-04-25
 */

public interface InnerUserService {
    /**
     * 数据库中是否分配给用户秘钥
     *
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);

}
