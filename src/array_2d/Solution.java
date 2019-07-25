package array_2d;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int result = maxHourglassLength(arr);
        System.out.println(result);

        scanner.close();
    }

	static int maxHourglassLength(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int row = 0; row <= arr.length-3; row++) {
			for (int col = 0; col <= arr.length-3; col++) {
				int sum = hourglassSum(arr, row, col);
				max = Math.max(max, sum);
			}
		}
		return max;
		
	}

	static int hourglassSum(int[][] arr, int row, int col) {
		int sum = 0;
		for (int r = row; r < row+3; r++) {
			for (int c = col; c < col+3; c++) {
				if (r == row+1 && (c == col || c == col+2)) {
					continue;
				} else {
					sum += arr[r][c];
				}
			}
		}
		return sum;
	}
}

