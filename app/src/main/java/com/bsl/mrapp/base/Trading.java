package com.bsl.mrapp.base;



public class Trading {
    private String type;
    private String num;
    private String time;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Trading (String type, String num, String time){
        this.type = type;
        this.num = num;
        this.time = time;
    }
}
