package string_tokens;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();
        if (s.length() == 0) {
        	System.out.println("0");
        	scan.close();
        	return;
        }
        if (s.length() > 4*Math.pow(10, 5)) {
        	scan.close();
        	return;
        }
        
        String[] tokens = s.split("[ .,?!'@_]+");
        System.out.println(tokens.length);
        for (String t: tokens) {
        	System.out.println(t);
        }
        
        scan.close();
    }
}

