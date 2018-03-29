package com.oracle.handler;


import com.oracle.service.ArticleService;
import com.oracle.service.LikeService;
import com.oracle.service.UserService;
import com.oracle.vo.Article;
import com.oracle.vo.Article_child;
import com.oracle.vo.Likeuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleHandler {

    @Autowired
    ArticleService articleService;
    @Autowired
    LikeService likeService;

    @RequestMapping(value = "inserta.do",method = RequestMethod.GET)
    @ResponseBody
    public Article SaveArticle(Article article){

        articleService.saveArticle(article);
        System.out.println(article);
        article.setContents("");
        return article;
    }
    @RequestMapping(value = "deletearticle.do",method = RequestMethod.GET)
    @ResponseBody
    public void DeleteArticle(Article article){

        articleService.deleteArticle(article);
    }


    @RequestMapping(value = {"getpa.do","getinita.do"},method = RequestMethod.GET)
    @ResponseBody
    public List<Article_child> getNewArticle(String userid){
        List<Article_child>list=articleService.selectNewArticle(userid);
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "getra.do",method = RequestMethod.GET)
    @ResponseBody
    public List<Article_child> getOldArticle(int articleid, String userid){
        List<Article_child>list=articleService.selectOldArticle(articleid,userid);
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "like.do",method = RequestMethod.GET)
    @ResponseBody
    public Likeuser likeOne (Likeuser likeuser){
        System.out.println(likeuser);
        likeService.likeOne(likeuser);
        return likeuser;
    }

    @RequestMapping(value = "unlike.do",method = RequestMethod.GET)
    @ResponseBody
    public Likeuser unLikeOne (Likeuser likeuser){
        System.out.println(likeuser);
        likeService.unlikeOne(likeuser);
        return likeuser;
    }
}
