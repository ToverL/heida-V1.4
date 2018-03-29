package com.oracle.vo;


import java.sql.Timestamp;

public class Article {
  private String userid;//sessionID
  private long articleid;//文章ID
  private String nickname;//昵称
  private String headimg;//头像
  private String contents;//文章内容
  private long likednum;//点赞量
  private long commnum;//评论量
  private java.sql.Timestamp times;//文章时间
  private long anonymous;//是否匿名(0匿名1不匿名)

  public Article() {
    super();
  }


  @Override
  public String toString() {
    return "Article{" +
            "userid='" + userid + '\'' +
            ", articleid=" + articleid +
            ", nickname='" + nickname + '\'' +
            ", headimg='" + headimg + '\'' +
            ", contents='" + contents + '\'' +
            ", likednum=" + likednum +
            ", commnum=" + commnum +
            ", times=" + times +
            ", anonymous=" + anonymous +
            '}';
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


  public String getHeadimg() {
    return headimg;
  }

  public void setHeadimg(String headimg) {
    this.headimg = headimg;
  }


  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }


  public long getLikednum() {
    return likednum;
  }

  public void setLikednum(long likednum) {
    this.likednum = likednum;
  }


  public long getCommnum() {
    return commnum;
  }

  public void setCommnum(long commnum) {
    this.commnum = commnum;
  }


  public Timestamp getTimes() {
    return times;
  }

  public void setTimes(Timestamp times) {
    this.times = times;
  }

  public long getAnonymous() {
    return anonymous;
  }

  public void setAnonymous(long anonymous) {
    this.anonymous = anonymous;
  }

}
