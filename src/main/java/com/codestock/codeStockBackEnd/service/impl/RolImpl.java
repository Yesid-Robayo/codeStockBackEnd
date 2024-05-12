package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.RolDao;
import com.codestock.codeStockBackEnd.model.entity.Rol;
import com.codestock.codeStockBackEnd.service.IRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the Rol service implementation.
 * It implements the IRol interface and provides methods for managing roles.
 * It uses the RolDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.IRol
 * @see com.codestock.codeStockBackEnd.model.dao.RolDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class RolImpl implements IRol {

    private final RolDao rolDao;

    /**
     * Constructor for the RolImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param rolDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public RolImpl(RolDao rolDao) {
        this.rolDao = rolDao;
    }

    /**
     * Saves the given role.
     *
     * @param rol The role to be saved.
     * @return The saved role.
     */
    @Override
    @Transactional
    public Rol save(Rol rol) {
        return rolDao.save(rol);
    }

    /**
     * Deletes the role with the given id.
     *
     * @param id The id of the role to be deleted.
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        rolDao.deleteById(id);
    }

    /**
     * Finds the role with the given id.
     *
     * @param id The id of the role to be found.
     * @return The found role, or null if no role with the given id exists.
     */
    @Override
    @Transactional(readOnly = true)
    public Rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }
}