package com.example.fire;

public class UserProfile {

    public String userno;
    public  String username;
    public  String useremail;



public UserProfile(String userno,String username,String useremail)
{
    this.userno=userno;
    this.username=username;
    this.useremail=useremail;
}

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}
