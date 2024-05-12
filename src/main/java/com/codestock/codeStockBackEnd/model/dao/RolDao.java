package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Rol;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the Rol entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the Rol entity.
 * The CrudRepository interface provides methods for CRUD operations, including save, find, delete.
 *
 * @see org.springframework.data.repository.CrudRepository
 */
public interface RolDao extends CrudRepository<Rol, Integer> {

    /**
     * This method is used to find a Rol by its identifier.
     *
     * @param identifier The identifier of the Rol.
     * @return The Rol entity if found, null otherwise.
     */
    Rol findByIdentifier(String identifier);
}