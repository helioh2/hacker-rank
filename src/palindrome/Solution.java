package palindrome;

import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        System.out.println(isPalindrome(A));
        
    }

	static String isPalindrome(String a) {
		for (int i = 0; i < a.length()/2; i++) {
			if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
				return "No";
			}
		}	
		return "Yes";
	}
}




