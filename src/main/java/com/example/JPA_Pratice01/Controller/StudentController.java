package com.example.JPA_Pratice01.Controller;

import com.example.JPA_Pratice01.Entity.Student;
import com.example.JPA_Pratice01.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/std")
public class StudentController {

    @Autowired
    StudentServices services;

   @PostMapping("/save")
    public Student createStudent (@RequestBody Student student){
         return  services.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudent (){
     List<Student> list = services.getAllStudentData();
     return list;
    }

    @GetMapping("{id}")
    public Student getByIds (@PathVariable Integer id) {
       return services.getbyID(id);
    }

   @PutMapping ("/{id}")
    public Student Update (@PathVariable Integer id, @RequestBody Student student){
        return  services.updateData(id,student);
   }

   @DeleteMapping  ("/{id}")
   public String delete (@PathVariable Integer id){
          services.deleteById(id);

       return "Student with ID " + id + " has been deleted.";
   }


}
