package com.wsh.coding.guidelines.programmingcode;

/**
 * @Title: OrderStatusEnum
 * @ProjectName alibaba_coding_guidelines
 * @Description: 订单状态Enum
 * @Author WeiShiHuai
 * @Date 2018/10/8 14:16
 */
public enum OrderStatusEnum {

    ORDER_NOT_START("ORDER_NOT_START"),
    ORDER_END("ORDER_END"),
    ORDER_DOING("ORDER_DOING");

    private String value;

    OrderStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrderStatusEnum getName(String value) {
        switch (value) {
            case "ORDER_NOT_START":
                return ORDER_NOT_START;
            case "ORDER_DOING":
                return ORDER_DOING;
            case "ORDER_END":
                return ORDER_END;
            default:
                return null;
        }
    }

}
