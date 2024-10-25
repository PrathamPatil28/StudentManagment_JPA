package com.example.JPA_Pratice01.Services;

import com.example.JPA_Pratice01.Entity.Student;
import com.example.JPA_Pratice01.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

         @Autowired
        StudentRepo studentRepo;

        public Student saveStudent(Student student){
            return studentRepo.save(student);
        }

       public List<Student> getAllStudentData(){
            List<Student> studentList;
           studentList = studentRepo.findAll();
           return studentList;
       }

       public Student getbyID(Integer id){
            Optional<Student> byId = studentRepo.findById(id);
            Student student;
           student = byId.get();
           return student;
        }

        public Student updateData(Integer id , Student student){
            Student stud = null;
            Optional<Student> student1 = studentRepo.findById(id);
            if (student1.isPresent()){
              Student dbObject =student1.get();
              dbObject.setName(student.getName());
              dbObject.setEmail(student.getEmail());
              dbObject.setAge(student.getAge());

              stud = studentRepo.save(dbObject);
            }
            else {
                System.out.println("no data found");
            }
            return  stud;
        }

        public void  deleteById(Integer id){
              studentRepo.deleteById(id);
        }
}




