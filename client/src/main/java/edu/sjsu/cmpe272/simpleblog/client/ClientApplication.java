package edu.sjsu.cmpe272.simpleblog.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@SpringBootApplication
@Command
public class ClientApplication implements CommandLineRunner, ExitCodeGenerator {

    @Autowired
    CommandLine.IFactory iFactory;

    @Autowired
    private ConfigurableApplicationContext context;

    @Command(name = "post", description = "Post messages")
    @PostMapping("/messages/create")
    public int post(@Parameters String message, @Parameters(defaultValue = "null") String attachment) {
        System.out.println("I wish i knew how to send " + message);
        if (attachment !=null) {
            System.out.println("And upload " + attachment);
        }
        return 2;
    }
    @Command(name = "list", description = "List messages")
    static class ListPosts implements Callable<Integer>{
        @CommandLine.Option(names = "--starting", description = "Starting message ID")
        private int startingId;

        @CommandLine.Option(names = "--count", description = "Number of messages to retrieve")
        private int count = 10; // Default to 10 if not specified

        @CommandLine.Option(names = "--save-attachment", description = "Save attachments to files")
        private boolean saveAttachment;

        @Override
        public Integer call() throws Exception {
            return 2;
        }
    }

    @Command(name = "create", description = "Create userid")
    @PostMapping("/user/create")
    int create(@Parameters String id) {
        System.out.println("I wish i knew how to create " + id);
        return 2;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    int exitCode;

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(this, iFactory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
