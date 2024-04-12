package edu.sjsu.cmpe272.simpleblog.client.Requests;

public class PostRequest {
/**
 *
 *     "date": "2024-03-13T19:38-07:00",
 *     "author": "ben",
 *     "message": "hello world!",
 *     "attachment": "aSdlfkJ888oidfjwe+",
 *     "signature": "as/f32230FS+"
 *
 *
 * **/
    String date;
    String author;
    String message;
    String attachment;
    String signature;
    public PostRequest(String message, String attachment){
        this.message = message;
        this.attachment = attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAttachment() {
        return attachment;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getSignature() {
        return signature;
    }
}
