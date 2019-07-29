package big_decimal;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();
 
      	String[] s2 = new String[n];
      	for(int i=0;i<n;i++) {
      		s2[i] = s[i];
      	}
      	s = s2;
      	Arrays.sort(s, Collections.reverseOrder(
      			new Comparator<String>() {
      				@Override
      				public int compare(String arg0, String arg1) {
      					return new BigDecimal(arg0).compareTo(new BigDecimal(arg1));
      				}
				}));
      	
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}