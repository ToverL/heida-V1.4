package com.oracle.dao;

import com.oracle.vo.Article;
import com.oracle.vo.Comments;
import com.oracle.vo.Comments_child;
import com.oracle.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsDao {
    public void save(Comments comments);
    public void delete(Comments comments);
    public void userCommentsUp(User user);
    public void userCommentsDown(User user);
    public void articleCommentsUp(Article article);
    public void articleCommentsDown(Article article);
    public List<Comments_child>selectByArticleId(Comments comments);

}
