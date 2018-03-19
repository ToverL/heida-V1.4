package com.oracle.vo;

public class Likeuser {

  private String userid;//sessionID
  private long articleid;//文章ID


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

}
