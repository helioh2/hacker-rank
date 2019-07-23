package tag_extractor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	String result = extractFromTag(line);
          	System.out.println(result);
              
			testCases--;
		}
	}

	public static String extractFromTag(String line) {
		Pattern p = Pattern.compile("<(.*)>(.*)</\\1>");
		Matcher m = p.matcher(line);
		return m.group(1);
	}
}




