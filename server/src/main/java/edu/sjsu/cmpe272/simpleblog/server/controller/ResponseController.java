package edu.sjsu.cmpe272.simpleblog.server.controller;

import edu.sjsu.cmpe272.simpleblog.server.Requests.CreateRequest;
import edu.sjsu.cmpe272.simpleblog.server.Responses.CreateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    @PostMapping("/messages/list")
    public CreateResponse postCreated(@RequestBody CreateRequest request){
        return new CreateResponse(request.getUser(), request.getPublic_key());

    }

}
