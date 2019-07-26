package list;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
        	list.add(in.nextInt());
        }
        
        int q = in.nextInt();
        in.nextLine();
        for (int i = 0; i < q; i++) {
        	String command = in.next();
        	int index = in.nextInt();
        	if (command.equals("Insert")) {
            	int x = in.nextInt();
            	list.add(index, x);
        	} else if (command.equals("Delete")) {
        		list.remove(index);
        	}
        }
        
        for (Integer x: list) {
        	System.out.print(x+" ");
        }
    }
}

