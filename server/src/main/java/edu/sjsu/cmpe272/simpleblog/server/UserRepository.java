package edu.sjsu.cmpe272.simpleblog.server;

import edu.sjsu.cmpe272.simpleblog.server.dataClasses.User;
import org.springframework.data.repository.CrudRepository;

import java.security.PublicKey;
import java.util.List;


public interface UserRepository extends CrudRepository<User, String> {
    PublicKey findbyId(String id);
}



