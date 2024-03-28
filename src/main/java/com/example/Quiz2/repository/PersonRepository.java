package com.example.Quiz2.repository;

import com.example.Quiz2.entity.Person;
import com.example.Quiz2.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
