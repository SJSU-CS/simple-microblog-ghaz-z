package edu.sjsu.cmpe272.simpleblog.server.dataClasses;

public class User {
    String userID;
    String publicKey;
    public User(String userID, String publicKey){
        this.userID = userID;
        this.publicKey = publicKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getUserID() {
        return userID;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
