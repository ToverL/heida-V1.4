package com.oracle.dao;

import com.oracle.vo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public void saveUserInfo(User user);
}
