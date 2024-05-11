package com.codestock.codeStockBackEnd.service;

import com.codestock.codeStockBackEnd.model.entity.Password;
import org.springframework.transaction.annotation.Transactional;

public interface IPassword {
    @Transactional
    Password save(Password password);

    @Transactional
    void delete(Integer id);

    @Transactional(readOnly = true)
    Password findByIdUser(Integer id);
}
