package stack;

import java.util.*;
class Solution{
	
	public static boolean checkBalanced(String str) {
		Stack<Character> stack = new Stack<Character>();
        for (Character c: str.toCharArray()) {
        	switch (c) {
            	case '{':
            	case '(':
            	case '[':
            		stack.push(c);
            		break;
            	case '}':
            		if (!stack.isEmpty() && stack.peek().equals('{')) {
            			stack.pop();
            		} else {
            			return false;
            		}
            		break;
            	case ')':
            		if (!stack.isEmpty() && stack.peek().equals('(')) {
            			stack.pop();
            		} else {
            			return false;
            		}
            		break;
            	case ']':
            		if (!stack.isEmpty() && stack.peek().equals('[')) {
            			stack.pop();
            		} else {
            			return false;
            		}
            		break;
            }
        }
        
        return stack.isEmpty();
	}
	
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            System.out.println(checkBalanced(input)? "true": "false");
            
		}
		sc.close();
		
	}
	
	
}

