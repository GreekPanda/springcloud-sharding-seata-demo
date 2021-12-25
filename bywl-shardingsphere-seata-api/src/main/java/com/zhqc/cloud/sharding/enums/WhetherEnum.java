package com.zhqc.cloud.sharding.enums;

import com.zhqc.framerwork.common.interfaces.EnumInterface;

/**
 * @类说明:是否枚举
 * @author: zhangyu
 * @createTime: 2020/10/06
 * @updateAuthor: [修改作者]
 * @UpdateRemark: [说明本次修改内容]
 * @version 1.2.9
 */
public enum WhetherEnum implements EnumInterface {
    NO(0, "否"),
    YES(1, "是"),
    ;
    private int code;
    private String msg;

    // 构造方法
    private WhetherEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(int code) {
        for (WhetherEnum c : WhetherEnum.values()) {
            if (c.getCode() == code) {
                return c.msg;
            }
        }
        return null;
    }

    public static Integer getCode(String msg) {
        for (WhetherEnum c : WhetherEnum.values()) {
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
        return "WhetherEnum";
    }

}
