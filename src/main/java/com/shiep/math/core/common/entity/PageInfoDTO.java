package com.shiep.math.core.common.entity;

import lombok.Data;

/**
 * @author yixinwei
 * @date 2017/11/23 14:03
 */
@Data
public class PageInfoDTO {

    /** 每页的数量 */
    private Integer pageSize;
    /** 当前页 */
    private Integer pageNum;
    /** 总记录数 */
    private Long total;

}
