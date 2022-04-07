package com.ezetap.studentproject.service;
import com.ezetap.studentproject.bean.StudentInput;
import com.ezetap.studentproject.entity.Student;
import com.ezetap.studentproject.exception.ResourceNotFoundException;
import com.ezetap.studentproject.exception.ValidationException;
import com.ezetap.studentproject.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService implements EntityService {

    public static Boolean f;

    private  static final Logger logger= LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudent() {

        List<Student> studentList=null;
        studentList=studentRepository.findAll();
        if(studentList.size()!=0){
            return studentList;
        }else {
            logger.error("No recordes found");
            throw new ResourceNotFoundException("No recordes found");
        }
    }

    @Override
    public StudentInput createStudent(StudentInput input) {
        if(input !=null) {
            if (input.getName() != null && input.getName().length() > 4) {
                if (input.getEmail() != null && input.getEmail().length() > 10) {
                    if(input.getMobileNumber().length()==10){
                        Student student=new Student();
                        student.setName(input.getName());
                        student.setEmail(input.getEmail());
                        student.setMobileNumber(input.getMobileNumber());
                        student.setGender(input.getGender());
                        student.setDob(input.getDob());
                        student.setCollege(input.getCollege());
                        student.setAdmissionNumber(input.getAdmissionNumber());
                        student.setYearOfAdmission(input.getYearOfAdmission());
                        student.setBranch(input.getBranch());
                        student.setUsn(input.getUsn());

                        student=studentRepository.save(student);

                        input.setId(student.getId());
                        input.setName(student.getName());
                        input.setEmail(student.getEmail());
                        input.setMobileNumber(student.getMobileNumber());
                        input.setGender(student.getGender());
                        input.setDob(student.getDob());
                        input.setCollege(student.getCollege());
                        input.setAdmissionNumber(student.getAdmissionNumber());
                        input.setYearOfAdmission(student.getYearOfAdmission());
                        input.setBranch(student.getBranch());
                        input.setUsn(student.getUsn());
                        return input;
                    } else {
                        logger.error("Mobile number must be 10 digits");
                        throw new ValidationException("Mobile number must be 10 digits");
                    }
                } else {
                    logger.error("Email cannot be empty or less than 10");
                    throw new ValidationException("Email cannot be empty or less than 10");
                }
            } else {
                logger.error("Name cannot be empty or less than 4");
                throw new ValidationException("Name cannot be empty or less than 4");
            }
        }else{
            logger.error("Student cannot be empty");
            throw new ValidationException("Student is empty");
        }
    }

    @Override
    public StudentInput getStudentById(Integer id) throws ResourceNotFoundException{
        StudentInput input=null;
        Optional<Student> student=studentRepository.findById(id);
        if(student.isPresent()){
            input=new StudentInput();
            Student student1=student.get();
            input.setId(student1.getId());
            input.setName(student1.getName());
            input.setEmail(student1.getEmail());
            input.setMobileNumber(student1.getMobileNumber());
            input.setGender(student1.getGender());
            input.setDob(student1.getDob());
            input.setCollege(student1.getCollege());
            input.setAdmissionNumber(student1.getAdmissionNumber());
            input.setYearOfAdmission(student1.getYearOfAdmission());
            input.setBranch(student1.getBranch());
            input.setUsn(student1.getUsn());
        }else{
            logger.error("Student Record Not found");
            throw new ResourceNotFoundException("Student Record Not found");
        }
        return input;
    }

    @Override
    public StudentInput updateStudent(StudentInput input)throws ResourceNotFoundException {
        Optional<Student> student = studentRepository.findById(input.getId());

        if (student.isPresent()) {
            Student student1 = student.get();
            student1.setName(input.getName());
            student1.setEmail(input.getEmail());
            student1.setMobileNumber(input.getMobileNumber());
            student1.setGender(input.getGender());
            student1.setDob(input.getDob());
            student1.setCollege(input.getCollege());
            student1.setAdmissionNumber(input.getAdmissionNumber());
            student1.setYearOfAdmission(input.getYearOfAdmission());
            student1.setBranch(input.getBranch());
            student1.setUsn(input.getUsn());

            studentRepository.save(student1);

            StudentInput input1 = new StudentInput();
            input1.setId(student1.getId());
            input1.setName(student1.getName());
            input1.setEmail(student1.getEmail());
            input1.setMobileNumber(student1.getMobileNumber());
            input1.setGender(student1.getGender());
            input1.setDob(student1.getDob());
            input1.setCollege(student1.getCollege());
            input1.setAdmissionNumber(student1.getAdmissionNumber());
            input1.setYearOfAdmission(student1.getYearOfAdmission());
            input1.setBranch(student1.getBranch());
            input1.setUsn(student1.getUsn());
            return input1;
        } else {
            logger.error("Student not found");
            throw new ResourceNotFoundException("Student record not found");
        }
    }



    @Override
    public StudentInput deleteStudentById(Integer id) throws ResourceNotFoundException{
        StudentInput input=null;
        Optional<Student> student=studentRepository.findById(id);

        if(student.isPresent()){
            input=new StudentInput();
            Student student1=student.get();
            studentRepository.delete(student1);
            input.setId(student1.getId());
            input.setName(student1.getName());
            input.setEmail(student1.getEmail());
            input.setMobileNumber(student1.getMobileNumber());
            input.setGender(student1.getGender());
            input.setDob(student1.getDob());
            input.setCollege(student1.getCollege());
            input.setAdmissionNumber(student1.getAdmissionNumber());
            input.setYearOfAdmission(student1.getYearOfAdmission());
            input.setBranch(student1.getBranch());
            input.setUsn(student1.getUsn());
            return input;
        }else {
            logger.error("Student not found");
            throw new ResourceNotFoundException("Student not found");
        }
    }

    @Override
    public Boolean duplicateValidation(StudentInput input) {
        List<Student> studentList=null;
        studentList=studentRepository.findAll();
        if(studentList.isEmpty()){
            return true;
        }
        studentList.forEach(student1 -> {
            if(student1.getUsn()!=null){
                if(!(student1.getUsn().equals(input.getUsn()))){
                    StudentService.f=true;
                }else {
                    StudentService.f=false;
                }
            }
        });
        return StudentService.f;
    }
}
