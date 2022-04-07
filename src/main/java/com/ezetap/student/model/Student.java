package com.ezetap.student.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name="mobile_number")
    private String mobileNumber;
    @Column(name="gender")
    private String gender;
    @Column(name="dob")
    private String dob;
    @Column(name="college")
    private String college;
    @Column(name="admission_number")
    private Integer admissionNumber;
    @Column(name="year_of_admission")
    private Integer yearOfAdmission;
    @Column(name="branch")
    private String branch;
    @Column(name="usn")
    private String usn;

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

