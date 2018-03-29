package com.oracle.service;
import com.oracle.dao.UserDao;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.vo.User;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService{

    @Autowired
     UserDao userDao;

    @Transactional
    public void saveUserInfo(User user){
        User u = userDao.findOneById(user.getUserid());
        if(u == null){
            user.setArticlesnum(0);
            user.setCommnum(0);
            user.setLikednum(0);
            userDao.saveUserInfo(user);
        }else{
            System.out.println("已有此人");
           user.setLikednum(u.getLikednum());
           user.setCommnum(u.getCommnum());
           user.setSessionkey(u.getSessionkey());
           user.setArticlesnum(u.getArticlesnum());
        }
    }
    @Transactional
    public User getUserInfo(User user){
        return userDao.findOneById(user.getUserid());
    }

}
