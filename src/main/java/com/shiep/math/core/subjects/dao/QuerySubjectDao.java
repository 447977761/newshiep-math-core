package com.shiep.math.core.subjects.dao;

import com.shiep.math.core.subjects.entity.MathSubjectDTO;

import java.util.List;


public interface QuerySubjectDao {

    List<MathSubjectDTO> listMathSubject(MathSubjectDTO mathSubjectDTO);

}
