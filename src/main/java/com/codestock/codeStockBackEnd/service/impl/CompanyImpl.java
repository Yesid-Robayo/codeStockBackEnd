package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.CompanyDao;
import com.codestock.codeStockBackEnd.model.dto.CompanyDTO;
import com.codestock.codeStockBackEnd.model.entity.Company;
import com.codestock.codeStockBackEnd.service.ICompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the Company service implementation.
 * It implements the ICompany interface and provides methods for managing companies.
 * It uses the CompanyDao to interact with the database.
 * It is annotated with @Service to indicate that it's a service component in the Spring framework.
 * It is also annotated with @Transactional to manage the transactions.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.ICompany
 * @see com.codestock.codeStockBackEnd.model.dao.CompanyDao
 * @see org.springframework.stereotype.Service
 * @see org.springframework.transaction.annotation.Transactional
 */
@Service
public class CompanyImpl implements ICompany {

    private final CompanyDao companyDao;

    /**
     * Constructor for the CompanyImpl class.
     * It is annotated with @Autowired to allow Spring to resolve and inject collaborating beans into our bean.
     *
     * @param companyDao The DAO (Data Access Object) to interact with the database.
     */
    @Autowired
    public CompanyImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    /**
     * Saves the given company.
     *
     * @param companyDTO The company to be saved.
     * @return The saved company.
     */
    @Override
    @Transactional
    public Company save(CompanyDTO companyDTO) {
        Company company = Company.builder().idCompany(companyDTO.getIdCompany())
                .nit(companyDTO.getNit())
                .name(companyDTO.getName())
                .address(companyDTO.getAddress())
                .phone(companyDTO.getPhone())
                .build();
        return companyDao.save(company);
    }

    /**
     * Deletes the company with the given id.
     *
     * @param id The id of the company to be deleted.
     */
    @Override
    @Transactional
    public void deleteByIdCompany(Integer id) {
        companyDao.deleteById(id);
    }

    /**
     * Finds the company with the given id.
     *
     * @param id The id of the company to be found.
     * @return The found company, or null if no company with the given id exists.
     */
    @Override
    @Transactional(readOnly = true)
    public Company findByIdCompany(Integer id) {
        return companyDao.findById(id).orElse(null);
    }

    /**
     * Finds all companies.
     *
     * @return An iterable of all companies.
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<Company> findAllCompany() {
        return companyDao.findAll();
    }
}