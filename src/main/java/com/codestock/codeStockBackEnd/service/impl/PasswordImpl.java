package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.PasswordDao;
import com.codestock.codeStockBackEnd.model.entity.Password;
import com.codestock.codeStockBackEnd.service.IPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordImpl implements IPassword {

    private final PasswordDao passwordDao;

    @Autowired
    public PasswordImpl(PasswordDao passwordDao) {
        this.passwordDao = passwordDao;
    }

    @Override
    public Password save(Password password) {
        return passwordDao.save(password);
    }

    @Override
    public void delete(Integer id) {
        passwordDao.deleteById(id);
    }

    @Override
    public Password findByIdUser(Integer id) {
        return passwordDao.findByIdUser(id);
    }
}
