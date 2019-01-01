package com.shiep.math.core.subjects.entity;

import com.shiep.math.core.common.entity.PageInfoDTO;
import lombok.Data;


/**
 * @program: shiep-math-core
 * @description: 题目DTO
 * @author: liziyue
 * @create: 2018-11-25 15:41
 **/
@Data
public class MathSubjectDTO extends PageInfoDTO {

    private Long id;

    private String mathSubject;

    private String mathType;

    private String subjectTag;

    private String subjectOrigin;

    private String subjectProvince;

    private String subjectCity;

    private String subjectArea;

    private String subjectYear;

    private String MathSubjectFormat;
}
