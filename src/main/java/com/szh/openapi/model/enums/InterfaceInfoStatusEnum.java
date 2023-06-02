package com.szh.openapi.model.enums;

/**
 * Created by szh on 2023-04-22
 */

public enum InterfaceInfoStatusEnum {

    OFFLINE("关闭", 0),

    ONLINE("上线", 1);

    private final String text;

    private final int value;

    InterfaceInfoStatusEnum(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public Integer getValue() {
        return value;
    }
}
