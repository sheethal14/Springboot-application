package com.ezetap.student.dto;

import com.ezetap.student.model.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentDTO {
    private Integer id;
    @Size(min = 2,max=25)
    private String name;
    @NotBlank(message = "Please enter the email address")
    @Email(message = "Please enter a valid email address")
    private String email;
    @NotBlank(message = "Please enter the 10 digit mobile number")
    @Size(min=10,max =12)
    private String mobileNumber;
    @NotBlank(message = "Please enter the gender")
    private String gender;
    @NotBlank(message = "Please enter the Date of birth")
    private String dob;
   @NotBlank(message = "Please fill the college Name")
    private String college;
    private Integer admissionNumber;
    private Integer yearOfAdmission;
    private String branch;
    @NotBlank(message = "Please enter the usn")
    private String usn;

    public StudentDTO(){

    }


    public StudentDTO(Student student){
        this.id=student.getId();
        this.name=student.getName();
        this.email=student.getEmail();
        this.mobileNumber=student.getMobileNumber();
        this.gender=student.getGender();
        this.dob=student.getDob();
        this.college=student.getCollege();
        this.admissionNumber=student.getAdmissionNumber();
        this.yearOfAdmission=student.getYearOfAdmission();
        this.branch=student.getBranch();
        this.usn=student.getUsn();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(Integer admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public Integer getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(Integer yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

}
