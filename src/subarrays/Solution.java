package subarrays;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int[] a = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		a[i] = in.nextInt();
    	}
    	
    	int result = countSubArraysWithNegativeSum(a);
    	System.out.println(result);
    	
    	in.close();
    	
    }

	static int countSubArraysWithNegativeSum(int[] a) {	
		int count = 0;
		for (int size = 1; size <= a.length; size++) {
			for (int i = 0; i < a.length - size + 1; i++) {
				int sum = 0;
				for (int j = i; j < i + size; j++) {
					sum += a[j];
				}
				count = sum < 0? count+1: count;
			}
		}
		return count;
	}
}


