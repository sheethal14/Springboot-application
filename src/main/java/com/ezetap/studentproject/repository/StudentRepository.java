package com.ezetap.studentproject.repository;

import com.ezetap.studentproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
