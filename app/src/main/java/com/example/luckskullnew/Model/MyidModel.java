package com.example.luckskullnew.Model;

public class MyidModel {

    String id;
    String paymentgateway;
    String siteurl;
    String userphone;
    String userid;
    String password;
    String amount;
    String created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentgateway() {
        return paymentgateway;
    }

    public void setPaymentgateway(String paymentgateway) {
        this.paymentgateway = paymentgateway;
    }

    public String getSiteurl() {
        return siteurl;
    }

    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "MyidModel{" +
                "id='" + id + '\'' +
                ", paymentgateway='" + paymentgateway + '\'' +
                ", siteurl='" + siteurl + '\'' +
                ", userphone='" + userphone + '\'' +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", amount='" + amount + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
