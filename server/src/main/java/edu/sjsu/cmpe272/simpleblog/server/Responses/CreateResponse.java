package edu.sjsu.cmpe272.simpleblog.server.Responses;

import edu.sjsu.cmpe272.simpleblog.server.dataClasses.User;

import java.security.PublicKey;

public class CreateResponse {
    String message = "Welcome!";
    public CreateResponse(String userID, PublicKey publicKey){
        // we want to take the user and the public key and then store it
        // TO do this we want to make a User Object sooo:
        User user = new User(userID, publicKey);
    }
}


