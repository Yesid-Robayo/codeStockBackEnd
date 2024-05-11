package com.codestock.codeStockBackEnd.service.impl;

import com.codestock.codeStockBackEnd.model.dao.UserDao;
import com.codestock.codeStockBackEnd.model.dto.UserDTO;
import com.codestock.codeStockBackEnd.model.entity.User;
import com.codestock.codeStockBackEnd.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserImpl implements IUser {
    private final UserDao userDao;

    @Autowired
    public UserImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User save(UserDTO userDTO) {
        User user = User.builder().idUser(userDTO.getIdUser())
                .email(userDTO.getEmail()).build();
        return userDao.save(user);
    }


    @Override
    @Transactional
    public void deleteByIdPerson(Integer id) {

    }

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(Integer idPerson) {
        return null;
    }

   
}
