package com.oracle.vo;

import java.sql.Timestamp;

public class Comments {

  private int commentsid;//评论ID（自增ID）
  private String userid;//sessionID
  private long articleid;//文章ID
  private String nickname;//昵称
  private String contents;//评论内容
  private java.sql.Timestamp times;//时间

  public int getCommentsid() {
    return commentsid;
  }

  public void setCommentsid(int commentsid) {
    this.commentsid = commentsid;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  public long getArticleid() {
    return articleid;
  }

  public void setArticleid(long articleid) {
    this.articleid = articleid;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }


  public Timestamp getTimes() {
    return times;
  }

  public void setTimes(Timestamp times) {
    this.times = times;
  }

  @Override
  public String toString() {
    return "Comments{" +
            "commentsid=" + commentsid +
            ", userid='" + userid + '\'' +
            ", articleid=" + articleid +
            ", nickname='" + nickname + '\'' +
            ", contents='" + contents + '\'' +
            ", times='" + times + '\'' +
            '}';
  }
}
