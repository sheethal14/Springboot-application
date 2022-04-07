package com.ezetap.student.serviceImpl;

import com.ezetap.student.dto.StudentDTO;
import com.ezetap.student.model.Student;
import com.ezetap.student.repository.StudentRepository;
import com.ezetap.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createOrUpdateStudent(StudentDTO studentDTO) {
        Student student=convertDtoToModel(studentDTO);
        studentRepository.save(student);

    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> list=studentRepository.findAll();
        List<StudentDTO> studentDTOList=list.stream()
                .map(StudentDTO::new)
                .collect(Collectors.toCollection(ArrayList::new));
        return studentDTOList;
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO editStudent(Integer id) {
        Student student=studentRepository.getById(id);
        return convertModelToDTO(student);
    }
    private Student convertDtoToModel(StudentDTO studentDTO){
        Student student=new Student();
            student.setId(studentDTO.getId());
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            student.setMobileNumber(studentDTO.getMobileNumber());
            student.setGender(studentDTO.getGender());
            student.setDob(studentDTO.getDob());
            student.setCollege(studentDTO.getCollege());
            student.setAdmissionNumber(studentDTO.getAdmissionNumber());
            student.setYearOfAdmission(studentDTO.getYearOfAdmission());
            student.setBranch(studentDTO.getBranch());
            student.setUsn(studentDTO.getUsn());
            return student;
    }
    private StudentDTO convertModelToDTO(Student student){
        StudentDTO studentDTO=new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setMobileNumber(student.getMobileNumber());
        studentDTO.setGender(student.getGender());
        studentDTO.setDob(student.getDob());
        studentDTO.setCollege(student.getCollege());
        studentDTO.setAdmissionNumber(student.getAdmissionNumber());
        studentDTO.setYearOfAdmission(student.getYearOfAdmission());
        studentDTO.setBranch(student.getBranch());
        studentDTO.setUsn(student.getUsn());
        return studentDTO;

    }
}
