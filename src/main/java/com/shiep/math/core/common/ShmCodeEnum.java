package com.shiep.math.core.common;


public enum ShmCodeEnum{

    REQUEST_SUCCESS_200("200","请求成功"),
    REQUEST_FAIL_900("900","系统内部错误"),
    PAGE_HELPER_901("901","分页失败，pageNum、pageSize不能为空");

    private String code;
    private String desc;

    ShmCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
