package com.ezetap.student.controller;

import com.ezetap.student.dto.StudentDTO;
import com.ezetap.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/studentManage")
public class StudentMgrController {
    static  final Logger logger=LoggerFactory.getLogger(StudentMgrController.class);

@Autowired
private StudentService  studentService;

@GetMapping("/registration")
public  String reg( Map<String,Object> model){
    logger.info("Inside registration method");
    model.put("student",new StudentDTO());
    return "Registration";
}
@PostMapping("/home")
public String createStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult){
    logger.info("Inside Create method");
    if(bindingResult.hasErrors()){
        return "Registration";
    }else {
        studentService.createOrUpdateStudent(studentDTO);
        return "redirect:/studentManage/list";
    }
}
@GetMapping("/list")
public String listOfStudents(Model model){
    logger.info("List of students details");
    List<StudentDTO> studentDTOList=studentService.getAllStudent();
    model.addAttribute("student",studentDTOList);
    return "studentList";
}
@PostMapping("/delete")
public String deleteStudent(@RequestParam("id") String id){
    logger.info("Deleting student details by id");
    studentService.deleteStudent(Integer.parseInt(id));
    return "redirect:/studentManage/list";
}
@GetMapping("/edit")
public String editStudent(@RequestParam("id") String id, Map<String,Object> model){
    logger.info("Updating student details by id");
    StudentDTO studentDTO=studentService.editStudent(Integer.parseInt(id));
    model.put("student",studentDTO);
    return "Registration";
}
}
