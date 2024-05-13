package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.PasswordDao;
import com.codestock.codeStockBackEnd.model.entity.Password;
import com.codestock.codeStockBackEnd.service.IPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the Password service implementation.
 * It implements the IPassword interface and provides methods for managing passwords.
 * It uses the PasswordDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 * It is also annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IPassword
 * @see com.codestock.codeStockBackEnd.model.dao.PasswordDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class PasswordImpl implements IPassword {

    private final PasswordDao passwordDao;

    /**
     * Constructor for the PasswordImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param passwordDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public PasswordImpl(PasswordDao passwordDao) {
        this.passwordDao = passwordDao;
    }

    /**
     * Saves the given password.
     *
     * @param password The password to be saved.
     * @return The saved password.
     */
    @Override
    @Transactional
    public Password save(Password password) {
        return passwordDao.save(password);
    }

    /**
     * Deletes the password with the given id.
     *
     * @param id The id of the password to be deleted.
     */
    @Override
    @Transactional
    public void deleteByIdUser(Integer id) {
        passwordDao.deleteByIdUser(id);
    }

    /**
     * Finds the password with the given user id.
     *
     * @param id The id of the user whose password is to be found.
     * @return The found password, or null if no password with the given user id exists.
     */
    @Override
    @Transactional(readOnly = true)
    public Password findByIdUser(Integer id) {
        return passwordDao.findByIdUser(id);
    }
}