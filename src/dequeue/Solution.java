package dequeue;

import java.util.*;

public class Solution {
	
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Deque deque = new ArrayDeque<>();
//        int n = in.nextInt();
//        int m = in.nextInt();
//
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            int num = in.nextInt();
//            deque.addLast(num);
//            if (deque.size() == m) {
//                Set<Integer> set  = new HashSet<>(deque);
//                max = Math.max(max, set.size());
//                if (max == m){   
//                    break;
//                }
//                deque.removeFirst();
//            }
//        }
//        in.close();
//        System.out.println(max);
//    }
	
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
        	removeOld(deque, map, m);	
        	int num = in.nextInt();
        	addNew(deque, map, num);
        	
        	max = Math.max(max, map.size());
   
            if (max == m){   
                break;
            }
        }
        in.close();
        System.out.println(max);
    }
	static void addNew(Deque<Integer> deque, Map<Integer, Integer> map, Integer newInt) {
		deque.add(newInt);
		map.merge(newInt, 1, Integer::sum);
	}
	
	static void removeOld(Deque<Integer> deque, Map<Integer, Integer> map, Integer m) {
		if (deque.size() == m) {
			int old = deque.remove();
			if (map.get(old) == 1) {
				map.remove(old);
			} else {
				map.merge(old, -1, Integer::sum);
			}
		}
	}
}
