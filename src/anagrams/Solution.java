package anagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	static Map<Character, Integer> countFrequencyChars(String str) {
		Map<Character, Integer> frequencyMap = new HashMap<>();
    	for (Character c: str.toCharArray()) {
    		if (frequencyMap.containsKey(c)) {
    			frequencyMap.replace(c, frequencyMap.get(c) + 1);
    		} else {
    			frequencyMap.put(c, 1);
    		}
    	}
    	return frequencyMap;
	}
	
//    public static boolean isAnagram(String a, String b) {
//    	if (a.length() != b.length()) {
//    		return false;
//    	}
//    	Map<Character, Integer> frequencyMapA = countFrequencyChars(a.toLowerCase());
//    	Map<Character, Integer> frequencyMapB = countFrequencyChars(b.toLowerCase());
//		return frequencyMapA.equals(frequencyMapB);
//    }
    
    public static boolean isAnagram(String a, String b) {
    	if (a.length() != b.length()) {
    		return false;
    	}
    	Map<Character, Integer> frequencyMapA = countFrequencyChars(a.toLowerCase());
    	for (Character c: b.toLowerCase().toCharArray()) {
    		if (!frequencyMapA.containsKey(c) || frequencyMapA.get(c) == 0) {
    			return false;
    		}
    		//else
    		frequencyMapA.replace(c, frequencyMapA.get(c) - 1);
    	}
    	
		return true;
    }
	

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
