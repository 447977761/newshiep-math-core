package com.shiep.math.core.subjects.controller;



import com.github.pagehelper.Page;
import com.shiep.math.core.common.ResponseEntity;
import com.shiep.math.core.common.ShmCodeEnum;
import com.shiep.math.core.subjects.entity.MathSubjectDTO;
import com.shiep.math.core.subjects.service.QuerySubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @program: shiep-math-core
 * @description: 题目查询页面
 * @author: liziyue
 * @create: 2018-11-25 12:13
 **/
@RestController
@RequestMapping("/mathSubject/subjects")
public class QuerySubjectController {

    @Autowired
    private QuerySubjectService querySubjectService;

    @RequestMapping("/listMathSubject")
    public ResponseEntity listMathSubject(@RequestBody MathSubjectDTO mathSubjectDTO){
        ResponseEntity re = new ResponseEntity();
        try{
            Page page = querySubjectService.listMathSubject(mathSubjectDTO);
            long total = page.getTotal();
            Map<String, Object> result = new HashMap<>();
            result.put("total", total);
            result.put("list", page.getResult());
            re.setResult(result);
            re.setSuccess(true);
            re.setCode(ShmCodeEnum.REQUEST_SUCCESS_200.getCode());
        }catch (Exception e){
            re.setSuccess(false);
            re.setCode(ShmCodeEnum.REQUEST_FAIL_900.getCode());
            re.setMessage(ShmCodeEnum.REQUEST_FAIL_900.getDesc());
        }
        return re;
    }



}
