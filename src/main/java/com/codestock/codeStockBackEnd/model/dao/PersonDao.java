package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * PersonDao interface extends CrudRepository.
 * This interface will be used to perform CRUD operations on Person entities.
 * The CrudRepository interface provides methods for CRUD operations, including save, find, delete.
 *
 * @see org.springframework.data.repository.CrudRepository
 */
public interface PersonDao extends CrudRepository<Person, Integer> {

}