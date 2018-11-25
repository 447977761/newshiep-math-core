package com.shiep.math.core.TestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.shiep.math.core.TestService.TestService;
import com.shiep.math.core.common.ResponseEntity;
import com.shiep.math.core.entity.MathSubjectDTO;
import com.shiep.math.core.utils.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: shiep-math-core
 * @description:
 * @author: Mr.Wang
 * @create: 2018-10-02 11:51
 **/
@RestController
@RequestMapping("/test/testWordProcess")
public class testController {

    @Autowired
    private TestService testService;

    private static List<Integer> saveSubjrct;



    @RequestMapping("/test")
    public ResponseEntity test(@RequestBody String param){
        ResponseEntity re = new ResponseEntity();
        Map<String, Object> result = new HashMap<String, Object>();
        JSONObject jo = JSON.parseObject(param);
        try{
            String imgUrl = jo.getString("imgUrl");
            String proImgUrl = imgUrl.substring(8,imgUrl.length());
            System.out.println("=====================");
            System.out.println(proImgUrl);
            String imgBase64b = Base64Utils.getImgStr(proImgUrl);
            imgBase64b = "data:image/png;base64,"+imgBase64b;
            result.put("origin", imgUrl);
            result.put("process", imgBase64b);
            re.setResult(result);
            re.setSuccess(true);
        }catch (Exception e){
            re.setSuccess(false);
            re.setMessage("处理失败，请联系技术人员");
        }

        return re;
    }

    @RequestMapping("/saveMath")
    public ResponseEntity saveMath(@RequestBody String param){
        ResponseEntity re = new ResponseEntity();
        Map<String, Object> result = new HashMap<String, Object>();
        testService.saveMath(param);
        re.setSuccess(true);
        re.setMessage("保存成功");
        return re;
    }

    @RequestMapping("/getResult")
    public ResponseEntity getResult(@RequestBody String param) throws Exception {
        ResponseEntity re = new ResponseEntity();
        Page mathSubjectDTO = testService.getResult(param,saveSubjrct);
        re.setResult(mathSubjectDTO);
        re.setSuccess(true);
        return re;
    }

    @RequestMapping("/saveSubject")
    public void saveSubject(@RequestBody String param) throws Exception {
        List<Integer> longList = new ArrayList<>();
        System.out.println(param);
        JSONObject jo = JSON.parseObject(param);
        JSONArray ja = jo.getJSONArray("id");

        for(int i=0;i<ja.size();i++){
            longList.add((Integer) ja.get(i));
        }
        saveSubjrct = longList;
        System.out.println(saveSubjrct.toString());
    }

    @RequestMapping("/getSubject")
    public ResponseEntity getSubject(){
        ResponseEntity re = new ResponseEntity();
        StringBuffer sb = testService.getSubject(saveSubjrct);
        re.setResult(sb);
        re.setSuccess(true);
        return re;
    }

    @RequestMapping("/getWord")
    public ResponseEntity getWord(@RequestBody String param) throws IOException {
        ResponseEntity re = new ResponseEntity();
        if(testService.htmlToWord(param)){
            re.setSuccess(true);
            re.setMessage("生成成功");
        }else {
            re.setSuccess(false);
            re.setMessage("生成失败");
        }
        return re;
    }
}
