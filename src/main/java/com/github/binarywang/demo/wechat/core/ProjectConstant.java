package com.github.binarywang.demo.wechat.core;

/**
 * 项目常量
 */
public final class ProjectConstant {

    //订单状态
    public static final int CANCEL = 0;//订单取消状态，长时间未付款
    public static final int RESERVE = 1;//订单预定状态    顾客微信服务号预定
    public static final int CONFIRM = 2;//订单确认状态    后台员工确认
    public static final int END = 3;//订单结束状态


    //抽奖次数变化状态
    public static final int LUCKY_DRAW = 1;             //抽奖
    public static final int ANSWER_QUESTION = 2;        //答题
    public static final int SIGN_IN = 3;                //签到，即预定房间

    //房间类型
    public static final int INTEGRITY = 1;              //整包房
    public static final int SCATTER = 0;                 //散客房


    public static final int ROOM_COUNT = 8;                 //散客房


}
