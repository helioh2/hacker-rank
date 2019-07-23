package strings_introduction;

import java.io.*;
import java.util.*;

public class Solution {

	static String capitalizeFirstLetter(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        System.out.println(A.length() + B.length());
        
        String answer2 = A.charAt(0) > B.charAt(0)? "Yes": "No"; 
        System.out.println(answer2);
        
        System.out.println(capitalizeFirstLetter(A) + " " +capitalizeFirstLetter(B));
          
    }
}




