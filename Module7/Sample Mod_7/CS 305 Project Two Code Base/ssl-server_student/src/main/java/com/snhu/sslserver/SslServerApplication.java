package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;

import java.time.Duration;


@SpringBootApplication
public class SslServerApplication {

	public final static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}

@RestController
class ServerController {
	
	private final Bucket bucket;

    public ServerController() {
        Bandwidth limit = Bandwidth.classic(20, Refill.greedy(20, Duration.ofMinutes(1)));
        this.bucket = Bucket.builder()
            .addLimit(limit)
            .build();
    }
	// Maps a route to the check sum
	@RequestMapping(value="/hash")
	final public String checkSumPage() {
				if (bucket.tryConsume(1)) {
					final String data = "Jesse Fjestad";
					final String checksum = getSHA(data);
					return "data: " + data + "<br>" + "Checksum hash: "+ checksum;
			    }
			return "Error too many requests";
	}
	
	// Maps a route for the home page
	@RequestMapping(value="/")
	final public String mainPage() {
		final String message = "Main Page <br> <a href=\"./hash\">File Checksum</a> ";
		
		return message;
	}
	

	// Converts a string of data into a secure hexadecimal hash
    private final static String getSHA(String data) {
    	MessageDigest mainDigest;
    	String secureHash = "";
		try {
			mainDigest = MessageDigest.getInstance("SHA-256");
			mainDigest.update(data.getBytes());
	    	byte[] digest = mainDigest.digest();
	    	secureHash = bytesToHex(digest);
		} catch (NoSuchAlgorithmException e) {
			secureHash = "Could not identify algorithm.";
		}
		return secureHash;
    }
    
    // Converts a byte array into a hexadecimal string
    private final static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }    
    
}


