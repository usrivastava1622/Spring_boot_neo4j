package com.infybuzz.controller;

import com.infybuzz.entity.Student;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.request.UpdateStudentRequest;
import com.infybuzz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	
	@Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody CreateStudentRequest createStudentRequest)
    {
        return studentService.create(createStudentRequest);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable(name = "Id") Long id)
    {
        return studentService.getStudentById(id);
    }
    @GetMapping("/getStudent/{name}")
    public List<Student> getStudent(@PathVariable(name = "Id") String name)
    {
        return studentService.findByName(name);

    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudent();
    }
    @PutMapping("/update/{Id}")
    public Student updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest)
    {
        return studentService.updateStudent(updateStudentRequest);
    }

    @GetMapping("/findByNameAndBirthYear/{name}/{BirthYear}")
    public List<Student> findByNameAndBirthYear(@PathVariable(name = "name")
                                                    String name,@PathVariable(name = "birthYear") Integer birthYear)
    {
        return studentService.findByNameAndBirthYear(name,birthYear);
    }


	
}
