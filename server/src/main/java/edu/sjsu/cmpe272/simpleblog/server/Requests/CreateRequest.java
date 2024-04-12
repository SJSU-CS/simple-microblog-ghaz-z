package edu.sjsu.cmpe272.simpleblog.server.Requests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Properties;

public class CreateRequest {
    String user;
    public PublicKey publicKey;

    private PrivateKey privateKey;
    private FileOutputStream mb;
    private boolean created = false;

    public CreateRequest(String user) throws Exception {
        /**if (!created){
            this.user = user;
            //this.public_key = public_key;
            //generating the 2 keys
            this.created = true;
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // Key size, you can adjust this as needed
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Get public and private keys
            this.publicKey = keyPair.getPublic();
            this.privateKey = keyPair.getPrivate();
        }
        else{
            //check for the ini file
            System.out.println("Error: User already exists");**/
        /**Properties properties = new Properties();

        try(FileInputStream fis = new FileInputStream("mb.ini")){
            properties.load(fis);
            System.err.println("User already exists.");

        } catch (IOException e){
            if (!created && validateUserID(user)){
                created = true;
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                keyPairGenerator.initialize(2048);
                KeyPair keyPair = keyPairGenerator.generateKeyPair();

                // Get public and private keys
                this.publicKey = keyPair.getPublic();
                this.privateKey = keyPair.getPrivate();




            }
            else{
                System.err.println("Error reading mb.ini file" + e.getMessage() + " or user ID not valid.");
            }
        }**/

        //Order of events:
            // 1. Check if user is valid
            // 2. Check if created has been updated
                    // 2a. If it has been tell the user that the file already exists.
            // 3. If ini file does exist then need to generate the key pair and make ini file
        if (validateUserID(user)){
            // so if the user is valid
            if (!this.created){
                this.created= true;
                this.user = user;
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                keyPairGenerator.initialize(2048); // Key size
                KeyPair keyPair = keyPairGenerator.generateKeyPair();
                this.publicKey = keyPair.getPublic();
                this.privateKey = keyPair.getPrivate();


                Properties properties = new Properties();
                String privateKeyString = Base64.getEncoder().encodeToString(this.privateKey.getEncoded());
                properties.setProperty(this.user, privateKeyString);

                try (FileOutputStream fos = new FileOutputStream("mb.ini")) {
                    properties.store(fos, "User IDs and private keys for MessageBoard");
                    System.out.println("mb.ini file created successfully.");
                } catch (IOException e) {
                    System.err.println("Error creating mb.ini file: " + e.getMessage());
                }

            }
            else{
                System.err.println("ERROR: User can only have one account. 'mb.ini' file already exists.");
            }
        }
        else {
            Exception invalidID = new Exception("ERROR: Invalid user ID");
            throw invalidID;
        }

    }

    public String getUser() {
        return user;
    }

    public void setUser(String message) {
        this.user = user;
    }

    public PublicKey getPublic_key() {
        return publicKey;
    }

    public static boolean validateUserID(String user){
        return user.matches("^[a-z0-9]+$");
    }

}
