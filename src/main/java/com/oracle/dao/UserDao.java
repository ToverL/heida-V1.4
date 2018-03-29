package com.oracle.dao;

import com.oracle.vo.Article;
import com.oracle.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public void saveUserInfo(User user);
    public User findOneById(@Param("userid") String userid);
}
