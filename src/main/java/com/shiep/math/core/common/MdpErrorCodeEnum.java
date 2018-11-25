package com.shiep.math.core.common;

/**
 * Created by za-yutao on 2017/3/17.
 */
public enum MdpErrorCodeEnum{

    REQUEST_SUCCESS_200("200","请求成功"),
	REQUEST_SUCCESS_201("201","上传成功"),
    ERROR_MDP_CORE_1000("1000", "系统内部错误"),
    ERROR_MDP_CORE_1001("1001", "请求参数错误"),
    ERROR_MDP_CORE_1002("1002", "无被查询的相关医院"),
    ERROR_MDP_CORE_1003("1003", "网关连接异常"),
    ERROR_MDP_CORE_1004("1004", "返回数据异常"),
    ERROR_MDP_CORE_1005("1005", "系统中无保险公司信息"),
    ERROR_MDP_CORE_1006("1006", "查询不到相关医疗数据"),
    ERROR_MDP_CORE_1007("1007", "第三方数据平台错误"),
    ERROR_MDP_CORE_1008("1008", "无对应第三方数据平台"),
    ERROR_MDP_CORE_1009("1009", "异步请求"),
    ERROR_MDP_CORE_1010("1010", "异步请求，查询中请稍后"),
    ERROR_MDP_CORE_1011("1011", "解密验签失败"),
    ERROR_MDP_CORE_1012("1012","重复请求"),
    ERROR_MDP_CORE_1013("1013","非法请求"),
    ERROR_MDP_CORE_1014("1014", "无被查询的相关数据"),
    ERROR_MDP_CORE_1015("1015", "报案号和投保单号必填一项"),
    ERROR_MDP_CORE_1016("1016","不支持的查询时间"),
    ERROR_MDP_CORE_1017("1017", "导入模板前先填入保险公司"),
    ERROR_MDP_CORE_1018("1018", "导入模板前先填入省市区"),
    ERROR_MDP_CORE_1019("1019", "请求区卫平台出错"),

    ERROR_MDP_POLICY_CHECK_FAILED("2001", "保单立案检验失败,报案号：{0},保单No:{1},原因:{2}"),
    ERROR_MDP_POLICY_CHECK_200002("2002", "保险公司ID:{0},报案号:{1}查询抄单保单不成功"),
    ERROR_MDP_POLICY_CHECK_200003("2003", "保单立案检验失败,报案号：{0},公司ID:{1},原因:{2}"),
    ERROR_MDP_POLICY_STATUS_IS_NOT_COMPENSABLE("2004", "保单状态不是可理赔状态"),

    INVALID_PARAMETER("3001", "参数不合法"),
    MERCHANT_ID_IS_NOT_NULL("3002", "保险公司代码不能为空"),
    API_TOTAL_COUNT_OVERRUN("3003", "调用次数超出限额"),
    API_DAY_COUNT_OVERRUN("3004", "日调用次数超出限额"),
    API_MERCHANT_NOT_FOND("3005", "未知对应保险公司或接口"),
    API_IS_NOT_AUTHORIZATION("3006", "没有权限"),

    CASE_NOT_EXIT("4001","案件不存在"),
    CASE_IN_PROGRESS("4002","案件处理中"),
    ERROR_POLICYLIST("4003","承保保单列表不符合要求");

	

	



    private String code;
    private String desc;

    private MdpErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }



    public static MdpErrorCodeEnum getResultEnumByDesc(String desc) {
        for (MdpErrorCodeEnum statusEnum : MdpErrorCodeEnum.values()) {
            if (statusEnum.getDesc().equals(desc)) {
                return statusEnum;
            }
        }
        return null;
    }

    public static MdpErrorCodeEnum getResultEnunByCode(String code) {
        for (MdpErrorCodeEnum statusEnum : MdpErrorCodeEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }
        return null;
    }
}
