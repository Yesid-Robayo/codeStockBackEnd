package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.dto.PersonDTO;
import com.codestock.codeStockBackEnd.model.entity.Person;
import org.springframework.transaction.annotation.Transactional;

/**
 * IPerson interface.
 * This interface defines the contract for the Person service.
 * It includes methods for saving, deleting, finding by id, and finding all Person entities.
 */
public interface IPerson {

    /**
     * Save a Person entity.
     * This method takes a PersonDTO object as input, converts it to a Person entity, and saves it in the database.
     * It uses Spring's @Transactional annotation to handle transactions.
     *
     * @param personDTO The PersonDTO object to be converted and saved.
     * @return The saved Person entity.
     */
    @Transactional
    Person save(PersonDTO personDTO);



    /**
     * Delete a Person entity by its id.
     * This method deletes a Person entity from the database based on its id.
     *
     * @param id The id of the Person entity to be deleted.
     */
    @Transactional
    void delete(Integer id);

    /**
     * Find a Person entity by its id.
     * This method finds a Person entity in the database based on its id.
     *
     * @param id The id of the Person entity to be found.
     * @return The found Person entity, or null if not found.
     */
    @Transactional (readOnly = true)
    Person findById(Integer id);

    /**
     * Find all Person entities.
     * This method finds all Person entities in the database.
     *
     * @return An Iterable of all Person entities.
     */
    @Transactional (readOnly = true)
    Iterable<Person> findAll();
}