package com.shiep.math.core.entity;

import lombok.Data;

/**
 * @program: shiep-math-core
 * @description:
 * @author: Mr.Wang
 * @create: 2018-10-14 14:23
 **/
@Data
public class MathSubjectDTO {

    private Long id;

    private String mathSubject;

    private String mathType;

    private String mathOrigin;

    private String mathSubjectFormat;

    private String selectValue;

}
