package com.oracle.vo;

public class Article_child extends Article {
    private int likeflag;
    private int delflag;

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public Article_child() {
    }

    public int getLikeflag() {
        return likeflag;
    }

    public void setLikeflag(int likeflag) {
        this.likeflag = likeflag;
    }

    @Override
    public String toString() {
        return "Article_child{" +
                "likeflag=" + likeflag +
                ", delflag=" + delflag +
                "} " + super.toString();
    }
}
