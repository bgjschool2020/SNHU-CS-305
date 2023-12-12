package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}

@RestController
class ServerController{
    //FIXME:  Add hash function to return the checksum value for the data string that should contain your name.

	// Loosely based on the ZenKhifer's example from https://brogramo.com/checksum-verification-using-an-encryption-algorithm-cipher-that-avoids-collisions/
	public String createHash(String data) throws NoSuchAlgorithmException {
		
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // creating object using the SHA-256 algorithm.
		String checkSum = null;
		
		messageDigest.update(data.getBytes());
		byte[] digest = messageDigest.digest();
		checkSum = bytesToHex(digest);
		
		return checkSum;
	}
	
    @RequestMapping("/hash")
    public String myHash() throws NoSuchAlgorithmException {
    	String data = "Hello World Check Sum!";
        String hash = createHash(data);
    	
        return "<p>data: "+data + "				SHA-256: " + hash;
    }
    
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte bite : bytes) {
            hexString.append(String.format("%02X", bite));
        }
        return hexString.toString();
    }
}
