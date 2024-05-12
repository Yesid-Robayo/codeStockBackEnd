package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.RolUser;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the RolUser entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the RolUser entity.
 */
public interface RolUserDao extends CrudRepository<RolUser, Integer> {

    /**
     * This method is used to find a RolUser by the user's ID.
     *
     * @param idUser The ID of the user.
     * @return The RolUser entity if found, null otherwise.
     */
    RolUser findByIdUser(Integer idUser);

    /**
     * This method is used to find a RolUser by the role's ID.
     *
     * @param idRole The ID of the role.
     * @return The RolUser entity if found, null otherwise.
     */
    RolUser findByIdRole(Integer idRole);

    /**
     * This method is used to delete a RolUser by the user's ID.
     *
     * @param id The ID of the user.
     */
    void deleteByIdUser(Integer id);
}