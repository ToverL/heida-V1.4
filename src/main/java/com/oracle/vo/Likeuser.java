package com.oracle.vo;

public class Likeuser {
  private int likeid;//点赞id（默认自增）
  private String userid;//sessionID
  private long articleid;//文章ID

  public int getLikeid() {
    return likeid;
  }

  public void setLikeid(int likeid) {
    this.likeid = likeid;
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

  @Override
  public String toString() {
    return "Likeuser{" +
            "likeid=" + likeid +
            ", userid='" + userid + '\'' +
            ", articleid=" + articleid +
            '}';
  }
}
