package array_1d_2;

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
		if (game[0] == 1) {
			return false;
		}
		if (canReachEnd(leap, game, 0)) {
			return true;
		}    	
        return false;
    }

    
    
    static boolean canReachEnd(int leap, int[] game, int index) {
    	
    	if (index >= game.length) {
    		return true;
    	}
    	
    	while (canGoForwards(1, game, index)) {
    		index = forward(1, index);
    		if (index >= game.length) {
        		return true;
        	}
    	}
    	
    	for (int i = 0; i < leap - 1; i++) {
    		if (canGoForwards(leap, game, index)) {
    			if (canReachEnd(leap, game, forward(leap, index))) {
    				return true;
    			}
    		}
    		if (!canGoBackwards(game, index)) return false;
    		index = backward(index);
    	}

		return false;

	}

	private static boolean canGoBackwards(int[] game, int index) {
		return index > 0 && game[backward(index)] != 1;
	}

	static boolean canGoForwards(int leap, int[] game, int index) {
		return forward(leap, index) >= game.length || game[forward(leap, index)] == 0;
	}

	static int forward(int leap, int index) {
		return index+leap;
	}

	static int backward(int index) {
		return index-1;
	}

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

