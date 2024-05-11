package com.codestock.codeStockBackEnd.controller;

import com.codestock.codeStockBackEnd.model.dto.PersonDTO;
import com.codestock.codeStockBackEnd.model.entity.Person;
import com.codestock.codeStockBackEnd.service.IPerson;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
     * Update a Person entity.
     * It uses Spring's @PutMapping annotation to map this method to the PUT "/person" request.
     * It returns a PersonDTO object after updating the person.
     *
     * @param dataDTO The PersonDTO object to be updated.
     * @return The updated PersonDTO object.
     */
    @PutMapping("/person")
    public ResponseEntity<?> updatePerson(@Valid @RequestBody PersonDTO dataDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("Invalid data provided");
            }
            Person person = personService.findById(dataDTO.getIdPerson());
            PersonDTO personDTO = PersonDTO.builder().IdPerson(person.getIdPerson())
                    .name(person.getName())
                    .lastName(person.getLastName())
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

            if (dataDTO.getPhone() != null) {
                personDTO.setPhone(dataDTO.getPhone());
            }
            if (dataDTO.getDateOfBirth() != null) {
                personDTO.setDateOfBirth(dataDTO.getDateOfBirth());
            }

            person = personService.save(personDTO);
            return ResponseEntity.ok(PersonDTO.builder().IdPerson(person.getIdPerson())
                    .name(person.getName())
                    .lastName(person.getLastName())
                    .phone(person.getPhone())
                    .gender(person.getGender())
                    .dateOfBirth(person.getDateOfBirth()).build());

        } catch (DataException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating person");
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
    public ResponseEntity<?> getPersonById(@PathVariable Integer id) {
        try {


            Person person = personService.findById(id);
            if (person == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(PersonDTO.builder().IdPerson(person.getIdPerson())
                    .name(person.getName())
                    .lastName(person.getLastName())
                    .gender(person.getGender())
                    .phone(person.getPhone())
                    .dateOfBirth(person.getDateOfBirth()).build());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error finding person");

        }
    }

    /**
     * Find all Person entities.
     * It uses Spring's @GetMapping annotation to map this method to the GET "/persons" request.
     * It returns a list of PersonDTO objects.
     *
     * @return A list of all PersonDTO objects.
     */
    @GetMapping("/persons")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {

        try {
            Iterable<Person> persons = personService.findAll();
            List<PersonDTO> personDTOList = new ArrayList<>();


            for (Person person : persons) {
                PersonDTO personDTO = PersonDTO.builder()
                        .IdPerson(person.getIdPerson())
                        .name(person.getName())
                        .lastName(person.getLastName())
                        .phone(person.getPhone())
                        .gender(person.getGender())
                        .dateOfBirth(person.getDateOfBirth())
                        .build();
                personDTOList.add(personDTO);
            }
            if(personDTOList.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(personDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}