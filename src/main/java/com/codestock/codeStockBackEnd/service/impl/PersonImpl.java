package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.PersonDao;
import com.codestock.codeStockBackEnd.model.dto.PersonDTO;
import com.codestock.codeStockBackEnd.model.entity.Person;
import com.codestock.codeStockBackEnd.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PersonImpl is a service class that implements the IPerson interface.
 * It provides methods to interact with the PersonDao.
 * It uses Spring's @Service annotation to indicate that it's a service class.
 * It also uses Spring's @Transactional annotation to handle transactions.
 */
@Service
public class PersonImpl implements IPerson {
    private final PersonDao personDao;

    /**
     * Constructor for PersonImpl.
     * It uses Spring's @Autowired annotation to automatically inject an instance of PersonDao.
     *
     * @param personDao The PersonDao to be injected.
     */
    @Autowired
    public PersonImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    /**
     * Save a Person entity.
     * It uses Spring's @Transactional annotation to handle transactions.
     * It converts a PersonDTO to a Person entity and saves it using the PersonDao.
     *
     * @param personDTO The PersonDTO to be converted and saved.
     * @return The saved Person entity.
     */
    @Override
    @Transactional
    public Person save(PersonDTO personDTO) {
        Person person = Person.builder().idPerson(personDTO.getIdPerson())
                .name(personDTO.getName())
                .lastName(personDTO.getLastName())
                .phone(personDTO.getPhone())
                .gender(personDTO.getGender())
                .dateOfBirth(personDTO.getDateOfBirth()).build();
        return personDao.save(person);
    }

    /**
     * Delete a Person entity by its id.
     * It uses Spring's @Transactional annotation to handle transactions.
     * It deletes a Person entity using the PersonDao.
     *
     * @param id The id of the Person entity to be deleted.
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        personDao.deleteById(id);
    }

    /**
     * Find a Person entity by its id.
     * It uses Spring's @Transactional annotation with readOnly set to true to handle transactions.
     * It finds a Person entity using the PersonDao.
     *
     * @param id The id of the Person entity to be found.
     * @return The found Person entity, or null if not found.
     */
    @Override
    @Transactional(readOnly = true)
    public Person findById(Integer id) {
        return personDao.findById(id).orElse(null);
    }

    /**
     * Find all Person entities.
     * It uses Spring's @Transactional annotation with readOnly set to true to handle transactions.
     * It finds all Person entities using the PersonDao.
     *
     * @return An Iterable of all Person entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findAll() {
        return personDao.findAll();
    }
}