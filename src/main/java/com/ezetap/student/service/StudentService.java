package com.ezetap.student.service;

import com.ezetap.student.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    public void createOrUpdateStudent(StudentDTO studentDTO);
    public List<StudentDTO> getAllStudent();
    public void deleteStudent(Integer id);
    public StudentDTO editStudent(Integer id);
}
