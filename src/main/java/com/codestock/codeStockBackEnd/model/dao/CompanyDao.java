package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface represents the Data Access Object (DAO) for the Company entity.
 * It extends the CrudRepository interface from Spring Data JPA to provide CRUD operations for the Company entity.
 */
public interface CompanyDao extends CrudRepository<Company, Integer> {
}