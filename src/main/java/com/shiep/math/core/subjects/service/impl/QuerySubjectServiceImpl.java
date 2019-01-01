package com.shiep.math.core.subjects.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiep.math.core.common.ShmCodeEnum;
import com.shiep.math.core.subjects.dao.QuerySubjectDao;
import com.shiep.math.core.subjects.entity.MathSubjectDTO;
import com.shiep.math.core.subjects.service.QuerySubjectService;
import com.shiep.math.core.utils.NoHtmlUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: shiep-math-core
 * @description: 题目查询界面
 * @author: liziyue
 * @create: 2018-11-25 12:19
 **/
@Service
@Transactional
public class QuerySubjectServiceImpl implements QuerySubjectService {

    private static Logger log = Logger.getLogger(QuerySubjectServiceImpl.class);

    @Autowired
    private QuerySubjectDao querySubjectDao;

    @Override
    public Page listMathSubject(MathSubjectDTO mathSubjectDTO) {
        Integer pageNum = mathSubjectDTO.getPageNum();
        Integer pageSize = mathSubjectDTO.getPageSize();
        if(null == pageNum || null == pageSize){
            log.error("["+ShmCodeEnum.PAGE_HELPER_901.getCode()+"]:"+ShmCodeEnum.PAGE_HELPER_901.getDesc());
        }else{
            PageHelper.startPage(pageNum,pageSize,true);
        }

        List<MathSubjectDTO> mathSubjectDTOList = querySubjectDao.listMathSubject(mathSubjectDTO);

        for(int i=0;i<mathSubjectDTOList.size();i++){
            mathSubjectDTOList.get(i).setMathSubjectFormat(NoHtmlUtils.NoHTML(mathSubjectDTOList.get(i).getMathSubject()));
        }

        return (Page) mathSubjectDTOList;
    }
}
