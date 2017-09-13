package com.cs.wechat.enums;

/**
 * Created by cs on 2017/9/11.
 */
public enum ResultCode {

    SUCCESS(0, "请求成功"),
    PASSWORD_ERROR(10001, "用户名或密码错误"),
    PARAMETER_ERROR(10101, "参数错误"),
    ORDER_FAIL(20, "订单：确认失败"),
    PRICE_NOTSET(30, "价格：未设置"),
    WEAK_NET_WORK(-1, "网络异常，请稍后重试");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
