package com.tz.dream.budejie.bean;

/**
 * Created by Dream on 16/5/29.
 */
public class UserBean {

    private String username;
    private String password;
    private String sex;
    private String content;

    public UserBean(String username, String password, String sex, String content) {
        super();
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
