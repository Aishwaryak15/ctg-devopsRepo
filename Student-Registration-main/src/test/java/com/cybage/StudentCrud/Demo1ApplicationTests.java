package com.cybage.StudentCrud;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cybage.StudentCrud.domain.Student;
import com.cybage.StudentCrud.repository.StudentRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class Demo1ApplicationTests {

	@Autowired
	StudentRepository repo;

	@Test
	@Order(1)
	public void addStudent()
	{
		Student s = new Student();
		//s.setId(1L);
		s.setStudentname("Nikita");
		s.setCourse("BCA");
		s.setFee(65321);
		repo.save(s);
		assertNotNull(repo.findById(19L).get());
	}
	
	@Test
	@Order(2)
	public void getAllStudents()
	{
		List<Student> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getStudentById()
	{
		Student std = repo.findById(16L).get();
		assertEquals(55000,std.getFee());
	}
	
	@Test
	@Order(4)
	public void updateStudent()
	{
		Student std1 = repo.findById(15L).get();
		std1.setFee(44230);
		repo.save(std1);
		assertNotEquals(56002,repo.findById(15L).get().getFee());
	}
	
	@Test
	@Order(5)
	public void deleteStudent()
	{
		repo.deleteById(14L);
		assertThat(repo.existsById(14L)).isFalse();
	}
}
