package com.ezetap.studentproject.controller;
import com.ezetap.studentproject.bean.StudentInput;
import com.ezetap.studentproject.entity.Student;
import com.ezetap.studentproject.exception.ResourceNotFoundException;
import com.ezetap.studentproject.exception.ValidationException;
import com.ezetap.studentproject.repository.StudentRepository;
import com.ezetap.studentproject.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private  static final Logger logger= LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/get")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @PostMapping("/create")
    public ResponseEntity<StudentInput> createStudent(@RequestBody StudentInput input) {
        if(studentService.duplicateValidation(input)){
            input=studentService.createStudent(input);
            return ResponseEntity.ok(input);
        }else {
            logger.error("Duplicate entry for usn");
            throw  new ValidationException("Duplicate entry for usn");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentInput> getStudentById(@PathVariable Integer id)throws ResourceNotFoundException {
       StudentInput input=studentService.getStudentById(id);
        return ResponseEntity.ok(input);
    }
    @PutMapping("/update")
    public ResponseEntity<StudentInput> updateStudent(@RequestBody StudentInput input)throws ResourceNotFoundException{
          input=studentService.updateStudent(input);
        return ResponseEntity.ok(input);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<StudentInput> deleteStudentById(@PathVariable Integer id)throws ResourceNotFoundException{
       StudentInput input= studentService.deleteStudentById(id);
        return ResponseEntity.ok(input);
    }
}
