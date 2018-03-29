package com.oracle.service;

import com.oracle.dao.ArticleDao;
import com.oracle.dao.CommentsDao;
import com.oracle.dao.UserDao;
import com.oracle.vo.Article;
import com.oracle.vo.Comments;
import com.oracle.vo.Comments_child;
import com.oracle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.midi.Soundbank;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentsService {
    @Autowired
    UserDao userDao;
    @Autowired
    CommentsDao commentsDao;
    @Autowired
    ArticleDao articleDao;



    @Transactional
    public void saveComments(Comments comments){
        comments.setTimes(new Timestamp(System.currentTimeMillis()));
        User user = new User();
        Article article = new Article();
        user=userDao.findOneById(comments.getUserid());
        article=articleDao.findOneById((int)comments.getArticleid());
        System.out.println(comments);
        commentsDao.save(comments);
        commentsDao.articleCommentsUp(article);
        commentsDao.userCommentsUp(user);
    }


    public void deleteComments(Comments comments){
         User user = new User();
        Article article = new Article();
        user=userDao.findOneById(comments.getUserid());
        article=articleDao.findOneById((int)comments.getArticleid());
        commentsDao.delete(comments);
        commentsDao.articleCommentsDown(article);
        commentsDao.userCommentsDown(user);
    }
    public List<Comments_child> selectOneArticleAllComments(Comments comments){

        List<Comments_child>list=commentsDao.selectByArticleId(comments);

        Article article = articleDao.findOneById((int)comments.getArticleid());
        if(article.getUserid().equals(comments.getUserid())){
            for (Comments_child l:list) {
                l.setDelflag(1);
            }
        }else {
            for (Comments_child l : list) {
                if(l.getUserid().equals(comments.getUserid()))
                    l.setDelflag(1);
            }
        }
        return list;
    }
}
