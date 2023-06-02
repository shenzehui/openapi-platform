package com.szh.openapi.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 上下线请求
 *
 * @author szh
 */
@Data
public class IdRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}