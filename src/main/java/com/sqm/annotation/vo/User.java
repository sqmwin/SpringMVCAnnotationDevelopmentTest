package com.sqm.annotation.vo;

/**
 * <p>Value Object
 *
 * @author sqm
 * @version 1.0
 */
public class User {
    private String myusername;
    private String mypassword;
    private UserInformation userInformation;

    public String getMyusername() {
        return myusername;
    }

    public void setMyusername(String myusername) {
        this.myusername = myusername;
    }

    public String getMypassword() {
        return mypassword;
    }

    public void setMypassword(String mypassword) {
        this.mypassword = mypassword;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @Override
    public String toString() {
        return "User{" +
                "myusername='" + myusername + '\'' +
                ", mypassword='" + mypassword + '\'' +
                ", userInformation=" + userInformation +
                '}';
    }
}
