package com.example.Quiz2.service;


import com.example.Quiz2.entity.Person;
import com.example.Quiz2.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addNewPerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAllSales() {
        return personRepository.findAll();
    }

    public Person getPersonDataById(Long userId) {
        return personRepository.findById(userId).get();
    }

    public void savePerson(Person person) {
        personRepository.save(person);

    }
}
