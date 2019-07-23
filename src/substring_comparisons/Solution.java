package substring_comparisons;

import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        for (int i = 0; i + k <= s.length(); i++) {
            String subs = s.substring(i, i+k);
            if (smallest.equals("") || subs.compareTo(smallest) < 0) {
                smallest = subs;
            }
            if (largest.equals("") || subs.compareTo(largest) > 0) {
                largest = subs;
            }
        }
        
        
        return smallest + "\n" + largest;
    }




    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}