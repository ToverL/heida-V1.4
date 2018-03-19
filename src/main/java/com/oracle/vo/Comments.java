package com.oracle.vo;

public class Comments {

  private String userid;//sessionID
  private long articleid;//文章ID
  private String nickname;//昵称
  private String contents;//评论内容
  private String times;//时间


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


  public String getTimes() {
    return times;
  }

  public void setTimes(String times) {
    this.times = times;
  }

}
