package io.beka.service;

import io.beka.util.AppUtil;
import org.springframework.stereotype.Service;

@Service
public class DefaultEncryptService implements EncryptService {

    @Override
    public String encrypt(String password, String salt) {
        return AppUtil.genHashPassword(password, salt);
    }

    @Override
    public boolean check(String checkPassword, String realPassword) {
        return checkPassword.equals(realPassword);
    }
}
