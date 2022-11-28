package com.infybuzz.service;

import com.infybuzz.entity.Department;
import com.infybuzz.entity.IsLearning;
import com.infybuzz.entity.Student;
import com.infybuzz.entity.Subject;
import com.infybuzz.repository.DepartmentRepository;
import com.infybuzz.repository.StudentRepository;
import com.infybuzz.repository.SubjectRepository;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.request.CreateSubjectRequest;
import com.infybuzz.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Student create(CreateStudentRequest createStudentRequest) {

        Department department = new Department();
        // Subject subject=new Subject();
        department.setDepName(createStudentRequest.getDepartment().getDepName());
        departmentRepository.save(department);
        List<IsLearning> isLearningList=new ArrayList<>();
        if (createStudentRequest.getSubjectList() != null) {
            for (CreateSubjectRequest subjectRequest : createStudentRequest.getSubjectList()) {
                Subject subject = new Subject();
                subject.setSubName(subjectRequest.getSubjectName());
                subjectRepository.save(subject);

                //setting up relationShip
                IsLearning isLearning=new IsLearning();
                isLearning.setMarks(subjectRequest.getMarks());
                isLearning.setSubject(subject);
                isLearningList.add(isLearning);

            }
        }

        Student student=new Student();

        //student properties
        student.setName(createStudentRequest.getName());
        student.setCountry(createStudentRequest.getCountry());
        student.setBirthYear(createStudentRequest.getBirthYear());

        //relationships
        student.setDepartment(department);
        student.setIsLearningList(isLearningList);

        //saving student
        studentRepository.save(student);

        return student;

 }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getAllStudent() {
        return  studentRepository.findAll();
    }

    public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
        Student student=studentRepository.findById(updateStudentRequest.getId()).get();
        student.setName(updateStudentRequest.getName());
        student.setCountry(updateStudentRequest.getCountry());
        student.setBirthYear(updateStudentRequest.getBirthYear());
        studentRepository.save(student);
        return student;

    }

    public List<Student> findByNameAndBirthYear(String name, Integer birthYear) {
        return studentRepository.findByNameAndBirthYear(name,birthYear);

    }
}
