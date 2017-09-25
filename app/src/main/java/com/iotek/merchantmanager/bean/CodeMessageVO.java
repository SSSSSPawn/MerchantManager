package com.iotek.merchantmanager.bean;

/**
 * Created by admin on 2017/9/14.
 */

public class CodeMessageVO extends BaseBean {

    private int rspcod;
    private String rspmsg;

    public CodeMessageVO() {
    }

    public CodeMessageVO(int rspcod, String rspmsg) {
        this.rspcod = rspcod;
        this.rspmsg = rspmsg;
    }

    public int getRspcod() {
        return rspcod;
    }

    public void setRspcod(int rspcod) {
        this.rspcod = rspcod;
    }

    public String getRspmsg() {
        return rspmsg;
    }

    public void setRspmsg(String rspmsg) {
        this.rspmsg = rspmsg;
    }

    @Override
    public String toString() {
        return "CodeMessageVO{" +
                "rspcod=" + rspcod +
                ", rspmsg='" + rspmsg + '\'' +
                '}';
    }
}
