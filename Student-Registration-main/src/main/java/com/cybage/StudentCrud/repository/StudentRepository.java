package com.cybage.StudentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.StudentCrud.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	

}
