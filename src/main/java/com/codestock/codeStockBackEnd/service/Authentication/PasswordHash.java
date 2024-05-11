package com.codestock.codeStockBackEnd.service.Authentication;

import com.codestock.codeStockBackEnd.service.IPasswordHash;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordHash implements IPasswordHash {

    private static final int workload = 12;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return new String(saltBytes);
    }

    @Override
    public String encodePassword(String password, String salt) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(workload);
        return passwordEncoder.encode(salt + password);
    }

    @Override
    public boolean verifyPassword(String password, String hashedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(workload);
        return passwordEncoder.matches(password, hashedPassword);
    }

}
