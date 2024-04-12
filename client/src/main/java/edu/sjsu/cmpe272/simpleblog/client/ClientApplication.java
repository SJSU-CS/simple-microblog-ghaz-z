package edu.sjsu.cmpe272.simpleblog.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@SpringBootApplication
@Command
public class ClientApplication implements CommandLineRunner, ExitCodeGenerator {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    CommandLine.IFactory iFactory;

    @Autowired
    private ConfigurableApplicationContext context;

    @Command(name = "post", description = "Post messages")
    //@PostMapping(path = "/messages/create")
    public int post(@Parameters String message, @Parameters(defaultValue = "null") String attachment) {
        /**System.out.println("I wish i knew how to send " + message);
        if (attachment !=null) {
            System.out.println("And upload " + attachment);
        }
        return 2;**/



        //1. Request needs to be formatted into a post request
        //2. That request is then sent in and received by the server (we can worry about picking the information up on the server side)
        //3. Request body needs to match that of the one shown in the api (we can either define a class or make a JSON either works)
        return 2;
    }
    @Command(name = "list", description = "List messages")
    //@PostMapping("/messages/list")
    public int listing(@CommandLine.Option(names = "--starting",
            description = "Starting message ID") int startingID,
                       @CommandLine.Option(names = "--count", description = "Number of messages to retrieve", fallbackValue = "10") int count,
                       @CommandLine.Option(names = "--save-attachment", description = "Save attachments to files") boolean saveAttachment){
        // Want to check if the
        //if --save-attachment is given, a file will be created with the base64 decoded attachment named message-id.ou
        //the number of messages to retrieve may be greater than 20, so you may need to make additional requests under the covers. number defaults to 10.
        //if --starting is not give, start at the end.
        return 2;
    }

    @Command(name = "create", description = "Create userid")
    //@PostMapping("/user/create") //these cannot be postmapping these are requests that are being made
    int create(@Parameters String id) {
        //System.out.println("I wish i knew how to create " + id);

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
