package edu.sjsu.cmpe272.simpleblog.client;

public class CreateRequest {
    String user;
    String public_key;

    public CreateRequest(String user, String public_key){
        this.user = user;
        this. public_key = public_key;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String message) {
        this.user = user;
    }

    private String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String key) {
        this.public_key = key;
    }
}
