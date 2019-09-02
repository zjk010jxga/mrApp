package com.bsl.mrapp.base;
public class Authorized {
    private String phoneNum;

    public String getPhoneNum() {

        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public Authorized(String phoneNum){
        this.phoneNum = phoneNum;
    }
}
