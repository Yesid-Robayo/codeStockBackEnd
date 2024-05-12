package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the User Data Access Object (DAO) in the application.
 * It extends the CrudRepository interface from Spring Data JPA, which provides methods for CRUD operations.
 * The User entity class and its primary key type (Integer) are specified as generic parameters to CrudRepository.
 */
public interface UserDao extends CrudRepository<User, Integer> {

    /**
     * This method is used to find a User entity by its ID.
     *
     * @param id The ID of the User entity to be found.
     * @return The found User entity, or null if not found.
     */
    User findByIdPerson(Integer id);

    /**
     * This method is used to find a User entity by its email.
     *
     * @param email The email of the User entity to be found.
     * @return The found User entity, or null if not found.
     */

    User findByEmail(String email);
}