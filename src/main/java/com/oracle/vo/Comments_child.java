package com.oracle.vo;

public class Comments_child extends Comments {
    private int delflag;

    public Comments_child() {
        super();
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    @Override
    public String toString() {
        return "Comments_child{" +
                "delflag=" + delflag +
                "} " + super.toString();
    }
}
