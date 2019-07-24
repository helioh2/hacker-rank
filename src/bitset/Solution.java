package bitset;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();

        BitSet b1 = new BitSet(N);
        BitSet b2 = new BitSet(N);
        BitSet[] bs = { b1, b2 };

        for (int i = 0; i < M; i++) {
            String[] commandStr = in.nextLine().split(" ");
            String command = commandStr[0];
            int op1 = Integer.parseInt(commandStr[1]);
            int op2 = Integer.parseInt(commandStr[2]);

            switch (command) {
	            case "AND":
	                bs[op1-1].and(bs[op2-1]);
	                break;
	            case "OR":
	                bs[op1-1].or(bs[op2-1]);
	                break;
	            case "XOR":
	                bs[op1-1].xor(bs[op2-1]);
	                break;
	            case "FLIP":
	                bs[op1-1].flip(op2);
	                break;
	            case "SET":
	                bs[op1-1].set(op2);
	                break;
            }
            long num_b1 = b1.cardinality();
            long num_b2 = b2.cardinality();
            System.out.printf("%d %d\n", num_b1, num_b2);
        }

    }
}