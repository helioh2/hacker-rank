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
			
          	List<String> result = extractFromTag(line);
          	for (String r: result) {
          		System.out.println(r);
          	}
          	
              
			testCases--;
		}
	}

	public static List<String> extractFromTag(String line) {
		Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
		Matcher m = p.matcher(line);
		
		List<String> strings = new ArrayList<String>();
		
		while (m.find()) {
			strings.add(m.group(2));
		}
		
		return strings.isEmpty()? Arrays.asList("None"): strings;
	}
}




