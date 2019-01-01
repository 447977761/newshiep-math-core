package com.shiep.math.core.TestService.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shiep.math.core.TestDao.MathTestDao;
import com.shiep.math.core.TestService.TestService;
import com.shiep.math.core.utils.Base64Utils;
import com.shiep.math.core.utils.HtmlToWordUtils;
import com.shiep.math.core.utils.NoHtmlUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @program: shiep-math-core
 * @description:
 * @author: Mr.Wang
 * @create: 2018-10-05 10:36
 **/
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private MathTestDao mathTestDao;

    @Override
    public void saveMath(String param) {
        JSONObject jo = JSON.parseObject(param);
        String mathSubject = jo.getString("mathSubject");
        System.out.println(mathSubject);
        mathTestDao.saveMath(mathSubject);
    }

//    @Override
//    public Page getResult(String param,List<Integer> saveSubjrct) throws Exception {
//        JSONObject jo = JSON.parseObject(param);
//        String mathSubject = jo.getString("mathSubject");
//        Integer pageNum = jo.getInteger("pageNum");
//        Integer pageSize = jo.getInteger("pageSize");
//        if(null == pageNum || null == pageSize){
//            throw new Exception("分页参数不能为空");
//        }
//        PageHelper.startPage(pageNum,pageSize,true);
//        List<MathSubjectDTO> mathSubjectDTOS = mathTestDao.getResult(mathSubject);
//
//        for(int i=0;i<mathSubjectDTOS.size();i++){
//            mathSubjectDTOS.get(i).setMathSubjectFormat(NoHtmlUtils.NoHTML(mathSubjectDTOS.get(i).getMathSubject()));
//            mathSubjectDTOS.get(i).setSelectValue("");
//        }
//        return (Page) mathSubjectDTOS;
//    }

    @Override
    public StringBuffer getSubject(List<Integer> saveSubjrct) {
        StringBuffer sb = new StringBuffer();
        if(!CollectionUtils.isEmpty(saveSubjrct)){
            for(int i=0;i<saveSubjrct.size();i++) {
                sb.append(mathTestDao.getSubject(saveSubjrct.get(i).longValue())).append("<br/>");
            }
        }
        return sb;
    }

    @Override
    public boolean htmlToWord(String param) throws IOException {
        boolean flag = false;
        JSONObject jo = JSON.parseObject(param);
        String content = jo.getString("content");
        JSONArray ja = jo.getJSONArray("imgBase64");
        for(int i=0;i<ja.size();i++){
            String re = ja.get(i).toString().substring(22,ja.get(i).toString().length());
            Base64Utils.decodeBase64ToImage(re,"D://templetImage/",String.valueOf(i)+".jpg");
            content = content.replace(ja.get(i).toString(),"D://templetImage/"+String.valueOf(i)+".jpg");
        }
        System.out.println(content);
        if(HtmlToWordUtils.writeWordFile(content)){
            flag = true;
            Desktop.getDesktop().open(new File("D:\\test.doc"));
        }
        return flag;
    }
}
