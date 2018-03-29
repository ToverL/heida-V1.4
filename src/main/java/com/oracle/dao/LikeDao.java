package com.oracle.dao;

import com.oracle.vo.Article;
import com.oracle.vo.Likeuser;
import com.oracle.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeDao {
    public void saveLike(Likeuser likeuser);
    public void likeUp(User user);
    public void likeDown(User user);
    public  void LikeArticle(Article article);
    public void UnLikeArticle(Article article);
    public void deleteLike(Likeuser likeuser);
    public List<Likeuser> selectByUserId(@Param("userid")String userid);
}
