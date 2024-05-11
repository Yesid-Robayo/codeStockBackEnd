package com.codestock.codeStockBackEnd.controller;

import com.codestock.codeStockBackEnd.model.dto.PersonDTO;
import com.codestock.codeStockBackEnd.model.entity.Person;
import com.codestock.codeStockBackEnd.service.IPerson;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * PersonController is a REST controller that handles HTTP requests related to Person entities.
 * It uses Spring's @RestController annotation to indicate that it's a REST controller.
 * It uses Spring's @RequestMapping annotation to map this controller to the "/api/v1" path.
 * It uses Swagger's @Tag annotation to provide metadata for Swagger documentation.
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "Person", description = "Person Controller")
public class PersonController {

    private final IPerson personService;

    /**
     * Constructor for PersonController.
     * It uses Spring's @Autowired annotation to automatically inject an instance of IPerson.
     *
     * @param personService The IPerson to be injected.
     */
    @Autowired
    public PersonController(IPerson personService) {
        this.personService = personService;
    }

    /**
     * Create a Person entity.
     * It uses Spring's @PostMapping annotation to map this method to the POST "/person" request.
     * It returns a PersonDTO object after saving the person.
     *
     * @param personDTO The PersonDTO object to be created.
     * @return The created PersonDTO object.
     */
    @PostMapping("/person")
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) {
        Person personCreate = personService.save(personDTO);
        return PersonDTO.builder().Id(personCreate.getIdPerson())
                .name(personCreate.getName())
                .lastName(personCreate.getLastName())
                .gender(personCreate.getGender())
                .email(personCreate.getEmail())
                .phone(personCreate.getPhone())
                .dateOfBirth(personCreate.getDateOfBirth()).build();

    }

    /**
     * Update a Person entity.
     * It uses Spring's @PutMapping annotation to map this method to the PUT "/person" request.
     * It returns a PersonDTO object after updating the person.
     *
     * @param personDTO The PersonDTO object to be updated.
     * @return The updated PersonDTO object.
     */
    @PutMapping("/person")
    public PersonDTO updatePerson(@RequestBody PersonDTO dataDTO) {
        Person person = personService.findById(dataDTO.getId());
        PersonDTO personDTO = PersonDTO.builder().Id(person.getIdPerson())
                .name(person.getName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .gender(person.getGender())
                .phone(person.getPhone())
                .dateOfBirth(person.getDateOfBirth()).build();

        if (personDTO == null) {
            return null;
        }
        if (dataDTO.getName() != null) {
            personDTO.setName(dataDTO.getName());
        }
        if (dataDTO.getGender() != null) {
            personDTO.setGender(dataDTO.getGender());
        }
        if (dataDTO.getLastName() != null) {
            personDTO.setLastName(dataDTO.getLastName());
        }
        if (dataDTO.getEmail() != null) {
            personDTO.setEmail(dataDTO.getEmail());
        }
        if (dataDTO.getPhone() != null) {
            personDTO.setPhone(dataDTO.getPhone());
        }
        if (dataDTO.getDateOfBirth() != null) {
            personDTO.setDateOfBirth(dataDTO.getDateOfBirth());
        }

        person = personService.save(personDTO);
        return PersonDTO.builder().Id(person.getIdPerson())
                .name(person.getName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .phone(person.getPhone())
                .gender(person.getGender())
                .dateOfBirth(person.getDateOfBirth()).build();

    }

    /**
     * Delete a Person entity by its id.
     * It uses Spring's @DeleteMapping annotation to map this method to the DELETE "/person/{id}" request.
     * It returns a ResponseEntity object with HTTP status.
     *
     * @param id The id of the Person entity to be deleted.
     * @return ResponseEntity object with HTTP status.
     */
    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer id) {
        try {
            personService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Find a Person entity by its id.
     * It uses Spring's @GetMapping annotation to map this method to the GET "/person/{id}" request.
     * It returns a PersonDTO object.
     *
     * @param id The id of the Person entity to be found.
     * @return The found PersonDTO object, or null if not found.
     */
    @GetMapping("/person/{id}")
    public PersonDTO getPersonById(@PathVariable Integer id) {

        Person person = personService.findById(id);
        return PersonDTO.builder().Id(person.getIdPerson())
                .name(person.getName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .gender(person.getGender())
                .phone(person.getPhone())
                .dateOfBirth(person.getDateOfBirth()).build();
    }

    /**
     * Find all Person entities.
     * It uses Spring's @GetMapping annotation to map this method to the GET "/persons" request.
     * It returns a list of PersonDTO objects.
     *
     * @return A list of all PersonDTO objects.
     */
    @GetMapping("/persons")
    public List<PersonDTO> getAllPersons() {
        Iterable<Person> persons = personService.findAll();
        List<PersonDTO> personDTOList = new ArrayList<>();

        for (Person person : persons) {
            PersonDTO personDTO = PersonDTO.builder()
                    .Id(person.getIdPerson())
                    .name(person.getName())
                    .lastName(person.getLastName())
                    .email(person.getEmail())
                    .phone(person.getPhone())
                    .gender(person.getGender())
                    .dateOfBirth(person.getDateOfBirth())
                    .build();
            personDTOList.add(personDTO);
        }

        return personDTOList;
    }
}