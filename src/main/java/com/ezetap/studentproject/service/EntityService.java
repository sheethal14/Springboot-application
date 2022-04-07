package com.ezetap.studentproject.service;

import com.ezetap.studentproject.bean.StudentInput;
import com.ezetap.studentproject.entity.Student;

import java.io.Serializable;
import java.util.List;

public interface EntityService extends Serializable{

        List<Student> getAllStudent();
        StudentInput createStudent(StudentInput input);
        StudentInput getStudentById(Integer id);
        StudentInput updateStudent(StudentInput input);
        StudentInput deleteStudentById(Integer id);
         Boolean duplicateValidation(StudentInput input);
    }


