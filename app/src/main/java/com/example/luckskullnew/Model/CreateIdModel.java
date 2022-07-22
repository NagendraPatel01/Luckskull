package com.example.luckskullnew.Model;

public class CreateIdModel {

    String id;
    String name;
    String demoid;
    String demopassword;
    String imageurl;
    String websiteurl;
    String created_at;
    String updated_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDemoid() {
        return demoid;
    }

    public void setDemoid(String demoid) {
        this.demoid = demoid;
    }

    public String getDemopassword() {
        return demopassword;
    }

    public void setDemopassword(String demopassword) {
        this.demopassword = demopassword;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getWebsiteurl() {
        return websiteurl;
    }

    public void setWebsiteurl(String websiteurl) {
        this.websiteurl = websiteurl;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "CreateIdModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", demoid='" + demoid + '\'' +
                ", demopassword='" + demopassword + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", websiteurl='" + websiteurl + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
