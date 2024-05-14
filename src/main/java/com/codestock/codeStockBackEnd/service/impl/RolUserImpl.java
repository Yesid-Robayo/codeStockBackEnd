package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.RolUserDao;
import com.codestock.codeStockBackEnd.model.entity.RolUser;
import com.codestock.codeStockBackEnd.service.IRolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the RolUser service implementation.
 * It implements the IRolUser interface and provides methods for managing role users.
 * It uses the RolUserDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IRolUser
 * @see com.codestock.codeStockBackEnd.model.dao.RolUserDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class RolUserImpl implements IRolUser {

    private final RolUserDao rolUserDao;

    /**
     * Constructor for the RolUserImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param rolUserDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public RolUserImpl(RolUserDao rolUserDao) {
        this.rolUserDao = rolUserDao;
    }

    /**
     * Finds a role user by the user's ID.
     *
     * @param id The ID of the user.
     * @return The role user if found, null otherwise.
     */

    @Override
    public RolUser findByIdUser(Integer id) {
        return rolUserDao.findByIdUser(id);
    }

    /**
     * Saves the given role user.
     *
     * @param rolUser The role user to be saved.
     * @return The saved role user.
     */
    @Override
    @Transactional
    public RolUser save(RolUser rolUser) {
        return rolUserDao.save(rolUser);
    }

    /**
     * Deletes the role user with the given user id.
     *
     * @param id The id of the user to be deleted.
     */
    @Override
    @Transactional
    public void deleteByIdUser(Integer id) {
        rolUserDao.deleteByIdUser(id);
    }


}