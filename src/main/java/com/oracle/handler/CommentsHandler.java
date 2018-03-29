package com.oracle.handler;


import com.oracle.service.CommentsService;
import com.oracle.vo.Comments;
import com.oracle.vo.Comments_child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentsHandler {

    @Autowired
    CommentsService commentsService;

    @ResponseBody
    @RequestMapping(value = "savecomments.do",method = RequestMethod.GET)
    public Comments saveComments(Comments comments){
        commentsService.saveComments(comments);
        System.out.println(comments);
        comments.setContents("");
        return comments;
    }
    @ResponseBody
    @RequestMapping(value = "delcomments.do",method = RequestMethod.GET)
    public void delComments(Comments comments){
        commentsService.deleteComments(comments);
    }

    @ResponseBody
    @RequestMapping(value = "selcomments.do",method = RequestMethod.GET)
    public List<Comments_child> selectComments(Comments comments){
        System.out.println(comments);
        List<Comments_child> list=commentsService.selectOneArticleAllComments(comments);
        System.out.println(list);
        return list;
    }

}
