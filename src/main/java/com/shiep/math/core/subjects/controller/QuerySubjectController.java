package com.shiep.math.core.subjects.controller;

/**
 * @program: shiep-math-core
 * @description: 题目查询页面
 * @author: liziyue
 * @create: 2018-11-25 12:13
 **/

import com.shiep.math.core.subjects.service.QuerySubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mathSubject/subjects")
public class QuerySubjectController {

    @Autowired
    private QuerySubjectService querySubjectService;



}
