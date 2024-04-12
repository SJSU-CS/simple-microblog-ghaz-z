package edu.sjsu.cmpe272.simpleblog.client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;

@Service
public class SignatureService {

    @Autowired
    private ObjectMapper objectMapper; // Autowire Jackson ObjectMapper

    @Autowired
    private PrivateKey privateKey; // Autowire RSA Private Key

    public byte[] signObject(Object object) throws Exception {
        // Step 1: Serialize the object into a JSON string
        String jsonString = objectMapper.writeValueAsString(object);

        // Step 2: Remove all whitespace characters
        String compactJsonString = jsonString.replaceAll("\\s", "");

        // Step 3: Calculate the SHA-256 digest of the modified JSON string
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(compactJsonString.getBytes(StandardCharsets.UTF_8));

        // Step 4: Sign the digest using RSA
        Signature rsa = Signature.getInstance("SHA256withRSA");
        rsa.initSign(privateKey);
        rsa.update(hash);
        return rsa.sign();
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

}
