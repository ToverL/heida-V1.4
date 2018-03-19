package com.oracle.service;
import com.oracle.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.vo.User;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService{

    @Autowired
    private UserDao userDao;
    @Transactional
    public void saveUserInfo(User user){
        userDao.saveUserInfo(user);
    }
}
