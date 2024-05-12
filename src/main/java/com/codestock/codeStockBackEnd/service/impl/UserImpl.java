package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.UserDao;
import com.codestock.codeStockBackEnd.model.dto.UserDTO;
import com.codestock.codeStockBackEnd.model.entity.User;
import com.codestock.codeStockBackEnd.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the User service implementation.
 * It implements the IUser interface and provides methods for managing users.
 * It uses the UserDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IUser
 * @see com.codestock.codeStockBackEnd.model.dao.UserDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class UserImpl implements IUser {

    private final UserDao userDao;

    /**
     * Constructor for the UserImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param userDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public UserImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Saves the given user.
     *
     * @param userDTO The user to be saved.
     * @return The saved user.
     */
    @Override
    @Transactional
    public User save(UserDTO userDTO) {
        User user = User.builder().idUser(userDTO.getIdUser())
                .idPerson(userDTO.getIdPerson())
                .email(userDTO.getEmail()).build();
        return userDao.save(user);
    }

    /**
     * Deletes the user with the given id.
     *
     * @param id The id of the user to be deleted.
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        userDao.deleteById(id);
    }

    /**
     * Finds the user with the given email.
     *
     * @param email The email of the user to be found.
     * @return The found user, or null if no user with the given email exists.
     */
    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    /**
     * Finds the user with the given person id.
     *
     * @param id The id of the person to be found.
     * @return The found user, or null if no user with the given person id exists.
     */
    @Override
    public User findByIdPerson(Integer id) {
        return userDao.findByIdPerson(id);
    }
}