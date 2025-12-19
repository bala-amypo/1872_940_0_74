package com.example.demo.Serviceimpl;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.validation.Valid;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements StudentService{

    // private final StudentRepository studentRepository;
    // public StudentServiceImpl(StudentRepository studentRepository){
    //     this.studentRepository=studentRepository;
    // }

    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(@Valid Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
    }

    public Student updatedata(Long id, Student student){
        Student exists = getStudentById(id);
        exist.setName(student.getName());
        exist.setEmail(student.getEmail());
        return studentRepository.save(exist);
    }
}