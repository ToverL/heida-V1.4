package com.oracle.service;

import com.oracle.dao.ArticleDao;
import com.oracle.dao.LikeDao;
import com.oracle.dao.UserDao;
import com.oracle.vo.Article;
import com.oracle.vo.Likeuser;
import com.oracle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {
    @Autowired
    ArticleDao articleDao;
    @Autowired
    LikeDao likeDao;
    @Autowired
    UserDao userDao;

    @Transactional
    public void likeOne(Likeuser likeuser){
        User user=new User();
        Article article = new Article();
        user=userDao.findOneById(likeuser.getUserid());
        article=articleDao.findOneById((int)likeuser.getArticleid());
        likeDao.saveLike(likeuser);
        likeDao.LikeArticle(article);
        likeDao.likeUp(user);
    }

    @Transactional
    public void unlikeOne(Likeuser likeuser){
        User user=new User();
        Article article = new Article();
        user=userDao.findOneById(likeuser.getUserid());
        article=articleDao.findOneById((int)likeuser.getArticleid());
        likeDao.deleteLike(likeuser);
        likeDao.UnLikeArticle(article);
        likeDao.likeDown(user);
    }
}
