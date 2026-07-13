package com.kodewala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
