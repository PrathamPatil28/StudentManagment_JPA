package com.example.JPA_Pratice01.Repo;

import com.example.JPA_Pratice01.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository <Student ,Integer> {

}
