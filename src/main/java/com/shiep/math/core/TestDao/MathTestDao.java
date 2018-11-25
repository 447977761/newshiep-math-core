package com.shiep.math.core.TestDao;

import com.shiep.math.core.entity.MathSubjectDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MathTestDao {

    void saveMath(@Param("mathSubject") String mathSubject);

    List<MathSubjectDTO> getResult(@Param("mathSubject") String mathSubject);

    String getSubject(@Param("id") Long id);

}
