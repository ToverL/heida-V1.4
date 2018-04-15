package com.oracle.service;

import com.oracle.dao.ArticleDao;
import com.oracle.dao.Article_childDao;
import com.oracle.dao.LikeDao;
import com.oracle.dao.UserDao;
import com.oracle.vo.Article;
import com.oracle.vo.Article_child;
import com.oracle.vo.Likeuser;
import com.oracle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleDao articledao;
    @Autowired
    Article_childDao article_childDao;
    @Autowired
    UserDao userDao;
    @Autowired
    LikeDao likeDao;
    @Transactional
    public void saveArticle(Article article){
        article.setTimes(new Timestamp(System.currentTimeMillis()));
        article.setLikednum(0);
        article.setCommnum(0);
        articledao.saveArticle(article);
        User user = userDao.findOneById(article.getUserid());
        articledao.userUp(user);
    }
    @Transactional
    public void deleteArticle(Article article){
        User user = new User();
        user=userDao.findOneById(article.getUserid());
        articledao.userArticleDowen(user);
        articledao.deleteArticle(article);
    }


    @Transactional
    public List<Article_child> selectNewArticle(String userid){

         List<Article_child> list=article_childDao.selectNewArticle();
         List<Likeuser> like=likeDao.selectByUserId(userid);
        for (Article_child a :list) {
            if(a.getUserid().equals(userid))
                a.setDelflag(1);
            for (Likeuser l:like) {
                if(a.getArticleid()==l.getArticleid()){
                    a.setLikeflag(1);
                }
            }
        }
         return list;
    }

    @Transactional
    public List<Article_child> selectmyNewArticle(String userid){

        List<Article_child> list=article_childDao.selectmyNewArticle(userid);
        List<Likeuser> like=likeDao.selectByUserId(userid);
        for (Article_child a :list) {
            if(a.getUserid().equals(userid))
                a.setDelflag(1);
            for (Likeuser l:like) {
                if(a.getArticleid()==l.getArticleid()){
                    a.setLikeflag(1);
                }
            }
        }
        return list;
    }

    @Transactional
    public List<Article_child> selectmycomNewArticle(String userid){

        List<Article_child> list=article_childDao.selectmycomNewArticle(userid);
        List<Likeuser> like=likeDao.selectByUserId(userid);
        for (Article_child a :list) {
            if(a.getUserid().equals(userid))
                a.setDelflag(1);
            for (Likeuser l:like) {
                if(a.getArticleid()==l.getArticleid()){
                    a.setLikeflag(1);
                }
            }
        }
        return list;
    }

    @Transactional
    public List<Article_child> selectmylikeNewArticle(String userid){

        List<Article_child> list=article_childDao.selectmylikeNewArticle(userid);
        List<Likeuser> like=likeDao.selectByUserId(userid);
        for (Article_child a :list) {
            if(a.getUserid().equals(userid))
                a.setDelflag(1);
            for (Likeuser l:like) {
                if(a.getArticleid()==l.getArticleid()){
                    a.setLikeflag(1);
                }
            }
        }
        return list;
    }
    @Transactional
    public List<Article_child> selectOldArticle(int articleid ,String userid){
        List<Article_child> list=article_childDao.selectOldArticle(articleid);
        List<Likeuser> like=likeDao.selectByUserId(userid);
        for (Article_child a :list) {
            if(a.getUserid().equals(userid))
                a.setDelflag(1);
            for (Likeuser l:like) {
                if(a.getArticleid()==l.getArticleid()){
                    a.setLikeflag(1);
                }
            }
        }
        return list;
    }


    @Transactional
    public List<Article_child> selectmyOldArticle(int articleid ,String userid){
        List<Article_child> list=article_childDao.selectmyOldArticle(userid,articleid);
        List<Likeuser> like=likeDao.selectByUserId(userid);
        for (Article_child a :list) {
            if(a.getUserid().equals(userid))
                a.setDelflag(1);
            for (Likeuser l:like) {
                if(a.getArticleid()==l.getArticleid()){
                    a.setLikeflag(1);
                }
            }
        }
        return list;
    }


    @Transactional
    public List<Article_child> selectmycomOldArticle(int articleid ,String userid){
        List<Article_child> list=article_childDao.selectmycomOldArticle(userid,articleid);
        List<Likeuser> like=likeDao.selectByUserId(userid);
        for (Article_child a :list) {
            if(a.getUserid().equals(userid))
                a.setDelflag(1);
            for (Likeuser l:like) {
                if(a.getArticleid()==l.getArticleid()){
                    a.setLikeflag(1);
                }
            }
        }
        return list;
    }


    @Transactional
    public List<Article_child> selectmylikeOldArticle(int articleid ,String userid){
        List<Article_child> list=article_childDao.selectmylikeOldArticle(userid,articleid);
        List<Likeuser> like=likeDao.selectByUserId(userid);
        for (Article_child a :list) {
            if(a.getUserid().equals(userid))
                a.setDelflag(1);
            for (Likeuser l:like) {
                if(a.getArticleid()==l.getArticleid()){
                    a.setLikeflag(1);
                }
            }
        }
        return list;
    }
    @Transactional
    public List<Article> getArticleByUserId(User user){
        return articledao.getArticleByUserId(user);
    }
}
