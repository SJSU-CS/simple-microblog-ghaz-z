package edu.sjsu.cmpe272.simpleblog.server.dataClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.security.PublicKey;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userID;
    private PublicKey publicKey;


    public User(String userID, PublicKey publicKey){
        this.userID = userID;
        this.publicKey = publicKey;
    }

    protected User(){}

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public String getUserID() {
        return userID;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
