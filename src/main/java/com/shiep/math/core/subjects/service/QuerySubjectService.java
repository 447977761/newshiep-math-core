package com.shiep.math.core.subjects.service;

import com.github.pagehelper.Page;
import com.shiep.math.core.subjects.entity.MathSubjectDTO;

/**
 * @program: shiep-math-core
 * @description: 题目查询界面
 * @author: liziyue
 * @create: 2018-11-25 12:18
 **/
public interface QuerySubjectService {

    Page listMathSubject(MathSubjectDTO mathSubjectDTO);

}
