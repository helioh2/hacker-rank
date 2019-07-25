package arraylist;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	List<List<Integer>> lines = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    		int d = in.nextInt();
    		List<Integer> list = new ArrayList<>(d);
    		for (int j = 0; j < d; j++) {
    			list.add(in.nextInt());
    		}
    		lines.add(list);
    	}
    	
    	int q = in.nextInt();
    	for (int i = 0; i < q; i++) {
    		int x = in.nextInt();
    		int y = in.nextInt();
    		try {	
	    		System.out.println(lines.get(x-1).get(y-1));
    		} catch (IndexOutOfBoundsException e) {
    			System.out.println("ERROR!");
    		}
    	}
    }
}

