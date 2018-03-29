package com.oracle.dao;

import com.oracle.vo.Article;
import com.oracle.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao {
    public void saveArticle(Article article);
    public List<Article> selectNewArticle();
    public List<Article> selectOldArticle(@Param("articleid") int articleid);
    public Article findOneById(@Param("articleid") int articleid);
    public void userUp(User user);
    public  void deleteArticle(Article article);
    public void userArticleDowen(User user);
    public List<Article>getArticleByUserId(User user);
}
