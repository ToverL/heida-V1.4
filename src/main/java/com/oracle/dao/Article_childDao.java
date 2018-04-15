package com.oracle.dao;

import com.oracle.vo.Article;
import com.oracle.vo.Article_child;
import com.oracle.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Article_childDao {
    public void saveArticle(Article_child article);
    public List<Article_child> selectNewArticle();
    public List<Article_child> selectOldArticle(@Param("articleid") int articleid);
    public List<Article_child> selectmyNewArticle(@Param("userid") String userid);
    public List<Article_child> selectmyOldArticle(@Param("userid") String userid,@Param("articleid") int articleid);
    public Article findOneById(@Param("articleid") int articleid);
    public void userUp(User user);
    public  void deleteArticle(Article_child article);
    public void userArticleDowen(User user);
    public List<Article>getArticleByUserId(User user);
    public List<Article_child> selectmycomNewArticle(@Param("userid") String userid);
    public List<Article_child> selectmycomOldArticle(@Param("userid") String userid,@Param("articleid") int articleid);
    public List<Article_child> selectmylikeNewArticle(@Param("userid") String userid);
    public List<Article_child> selectmylikeOldArticle(@Param("userid") String userid,@Param("articleid") int articleid);

}
