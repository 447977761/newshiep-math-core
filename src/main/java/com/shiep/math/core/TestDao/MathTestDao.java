package com.shiep.math.core.TestDao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MathTestDao {

    void saveMath(@Param("mathSubject") String mathSubject);

    String getSubject(@Param("id") Long id);

}
