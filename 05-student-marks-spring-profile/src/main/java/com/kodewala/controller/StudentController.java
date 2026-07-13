package com.kodewala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.request.StudentRequest;
import com.kodewala.response.StudentResponse;
import com.kodewala.service.StudentService;

@RestController
@RequestMapping("/api/students")
@Profile("prod")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * POST /api/students
	 * Creates a new student.
	 */
	@PostMapping
	public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest request) {
		StudentResponse response = studentService.createStudent(request);
		// Returns a 201 CREATED status code along with the saved data
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	/**
	 * GET /api/students/{id}
	 * Fetches a single student by their ID.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
		StudentResponse response = studentService.getStudentById(id);
		// Returns a 200 OK status code
		return ResponseEntity.ok(response);
	}

	/**
	 * GET /api/students
	 * Fetches a list of all students.
	 */
	@GetMapping
	public ResponseEntity<List<StudentResponse>> getAllStudents() {
		List<StudentResponse> responses = studentService.getAllStudents();
		return ResponseEntity.ok(responses);
	}

	/**
	 * PUT /api/students/{id}
	 * Updates an existing student.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<StudentResponse> updateStudent(
			@PathVariable Long id, 
			@RequestBody StudentRequest request) {
		
		StudentResponse response = studentService.updateStudent(id, request);
		return ResponseEntity.ok(response);
	}

	/**
	 * DELETE /api/students/{id}
	 * Deletes a student from the database.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		// Returns a simple success message
		return ResponseEntity.ok("Student deleted successfully.");
	}
}