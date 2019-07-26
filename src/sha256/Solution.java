package sha256;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String msg = in.next();
    	in.close();
    	MessageDigest m;
    	try {
        	m = MessageDigest.getInstance("SHA-256");
    	} catch (NoSuchAlgorithmException e) {
    		System.out.println("ERRO");
    		return;
    	}
        m.update(msg.getBytes(), 0, msg.length());
        System.out.println(new BigInteger(1, m.digest()).toString(16));
    }
}
