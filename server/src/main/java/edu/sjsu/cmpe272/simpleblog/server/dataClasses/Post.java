package edu.sjsu.cmpe272.simpleblog.server.dataClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String date;
    String author;
    String message;
    String attachment;
    String signature;
    int message_id;
}
