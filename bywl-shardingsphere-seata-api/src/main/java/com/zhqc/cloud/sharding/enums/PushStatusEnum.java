package com.zhqc.cloud.sharding.enums;

import com.zhqc.framerwork.common.interfaces.EnumInterface;

/**
 * @类说明:推送状态枚举
 * @author: huangjiaquan
 * @createTime: 2020/10/06
 * @updateAuthor: [修改作者]
 * @UpdateRemark: [说明本次修改内容]
 * @version 1.2.9
 */
public enum PushStatusEnum implements EnumInterface {
    FAIL(0, "失败"),
    SUCCESS(1, "成功"),
    ;
    private int code;
    private String msg;

    // 构造方法
    private PushStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(int code) {
        for (PushStatusEnum c : PushStatusEnum.values()) {
            if (c.getCode() == code) {
                return c.msg;
            }
        }
        return null;
    }

    public static Integer getCode(String msg) {
        for (PushStatusEnum c : PushStatusEnum.values()) {
            if (c.msg.equals(msg)) {
                return c.code;
            }
        }
        return null;
    }

    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getMsg() {
        return msg;
    }


    @Override
    public String getKey() {
        return "PushStatusEnum";
    }
}
