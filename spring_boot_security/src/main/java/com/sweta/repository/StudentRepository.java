package com.sweta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweta.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
