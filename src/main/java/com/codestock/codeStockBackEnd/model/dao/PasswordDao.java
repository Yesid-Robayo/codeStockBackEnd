package com.codestock.codeStockBackEnd.model.dao;

import com.codestock.codeStockBackEnd.model.entity.Password;
import org.springframework.data.repository.CrudRepository;

public interface PasswordDao extends CrudRepository<Password, Integer> {
    Password findByIdUser(Integer id);
}
