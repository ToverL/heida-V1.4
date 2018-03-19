package com.oracle.vo;

public class User {

  private String userid;//sessionID
  private String headimg;//头像链接
  private String nickname;//昵称
  private long articlesnum;//发表文章数量
  private long likednum;//点赞量
  private long commnum;//评论数量

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getArticlesnum() {
        return articlesnum;
    }

    public void setArticlesnum(long articlesnum) {
        this.articlesnum = articlesnum;
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

    public String toString() {
    return "User{" +
            "userid='" + userid + '\'' +
            ", headimg='" + headimg + '\'' +
            ", nickname='" + nickname + '\'' +
            ", articlesnum=" + articlesnum +
            ", likednum=" + likednum +
            ", commnum=" + commnum +
            '}';
  }
}
