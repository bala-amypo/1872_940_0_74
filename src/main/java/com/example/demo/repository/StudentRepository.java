package com.example.demo.repository
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.aiml.entity.Student;
+
public interface StudentRepository extends JpaRepository<Student,Long>{

}