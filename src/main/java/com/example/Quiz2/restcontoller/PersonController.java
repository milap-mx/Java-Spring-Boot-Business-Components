package com.example.Quiz2.restcontoller;

import com.example.Quiz2.entity.Address;
import com.example.Quiz2.entity.Person;
import com.example.Quiz2.entity.Tweet;
import com.example.Quiz2.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public ResponseEntity<String> addNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
        return new ResponseEntity<>("Person added successfully", HttpStatus.CREATED);
    }


    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPerson() {
        return new ResponseEntity<>(personService.getAllSales(), HttpStatus.OK);
    }


    @GetMapping("/person/tweets/{userId}")
    public ResponseEntity<List<Tweet>> getsTweetsOfPerson(@PathVariable Long userId) {
        Person person = personService.getPersonDataById(userId);
        if (person != null) {
            return new ResponseEntity<>(person.getTweets(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/person/address/{userId}")
    public ResponseEntity<Address> getAddressOfPerson(@PathVariable Long userId) {
        Person person = personService.getPersonDataById(userId);
        if (person != null) {
            Address address = person.getAddress();
            if (address != null) {
                return new ResponseEntity<>(address, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{userId}/address")
    public ResponseEntity<String> updatePersonAddress(@PathVariable Long userId, @RequestBody Address newAddress) {
        Person person = personService.getPersonDataById(userId);
        if (person != null) {
            Address currentAddress = person.getAddress();
            if (currentAddress != null) {
                currentAddress.setStreet(newAddress.getStreet());
                currentAddress.setCity(newAddress.getCity());
                currentAddress.setProvince(newAddress.getProvince());
                currentAddress.setCountry(newAddress.getCountry());
                personService.savePerson(person);
                return new ResponseEntity<>("Person's address updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Person doesn't have an address to update", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
    }

}
