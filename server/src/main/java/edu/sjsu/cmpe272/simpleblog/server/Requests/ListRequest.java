package edu.sjsu.cmpe272.simpleblog.server.Requests;

public class ListRequest {
    int limit;
    int next;

    public ListRequest(int limit, int next){
        this.limit = limit;
        this.next = next;
    }

    public int getLimit() {
        return limit;
    }

    public int getNext() {
        return next;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
