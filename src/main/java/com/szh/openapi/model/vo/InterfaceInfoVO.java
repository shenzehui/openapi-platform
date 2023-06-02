package com.szh.openapi.model.vo;

import com.szh.openapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口信息分组视图
 *
 * @author szh
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 调用次数
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;
}