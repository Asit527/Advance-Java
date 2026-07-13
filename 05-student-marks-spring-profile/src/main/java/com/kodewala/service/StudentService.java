package com.kodewala.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.StudentEntity;
import com.kodewala.repository.StudentRepository;
import com.kodewala.request.StudentRequest;
import com.kodewala.response.StudentResponse;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * CREATE: Save a new student to the database
	 */
	public StudentResponse createStudent(StudentRequest request) {
		StudentEntity entity = new StudentEntity();
		entity.setName(request.getName());
		entity.setRollNo(request.getRollNo());
		entity.setTotalMarks(request.getTotalMarks());

		StudentEntity savedEntity = studentRepository.save(entity);

		return mapToResponse(savedEntity);
	}

	/**
	 * READ: Get a single student by their ID
	 */
	public StudentResponse getStudentById(Long id) {
		StudentEntity entity = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

		return mapToResponse(entity);
	}

	/**
	 * READ: Get a list of all students in the database
	 */
	public List<StudentResponse> getAllStudents() {
		List<StudentEntity> students = studentRepository.findAll();
		
		return students.stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}
	
	/**
	 * UPDATE: Modify an existing student's data
	 */
	public StudentResponse updateStudent(Long id, StudentRequest request) {
		StudentEntity existingEntity = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		
		existingEntity.setName(request.getName());
		existingEntity.setRollNo(request.getRollNo());
		existingEntity.setTotalMarks(request.getTotalMarks());
		
		StudentEntity updatedEntity = studentRepository.save(existingEntity);
		
		return mapToResponse(updatedEntity);
	}
	
	/**
	 * DELETE: Remove a student from the database
	 */
	public void deleteStudent(Long id) {
		if (!studentRepository.existsById(id)) {
			throw new RuntimeException("Student not found with id: " + id);
		}
		studentRepository.deleteById(id);
	}

	/**
	 * HELPER: Converts an Entity to a Response DTO to keep code clean and DRY.
	 */
	private StudentResponse mapToResponse(StudentEntity entity) {
		StudentResponse response = new StudentResponse();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setRollNo(entity.getRollNo());
		response.setTotalMarks(entity.getTotalMarks());
		return response;
	}
}