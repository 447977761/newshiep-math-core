package com.shiep.math.core.TestService;

import com.github.pagehelper.Page;

import java.io.IOException;
import java.util.List;

public interface TestService {

    void saveMath(String param);

    Page getResult(String param,List<Integer> saveSubjrct) throws Exception;

    StringBuffer getSubject(List<Integer> saveSubjrct);

    boolean htmlToWord(String content) throws IOException;
}
