package interviewCodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LearnCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String company="google";
      
      //method 1
      
     Set<Character> se= new HashSet<Character>();
     char[] array=company.toCharArray();
     for (char i : array) {
		se.add(i);
	 }
     System.out.println(se);
     
     //method 2
     
     List<Character> li=new ArrayList<Character>();
     for (char t : array) {
		if(!li.contains(t)) {
			li.add(t);
		}
	}
     System.out.println(li);
     
     
     //method 3
     char[] output=new char[array.length];
     for(int i=0;i<array.length;i++)
     {
    	 for(int j=1;j<array.length-1;j++)
    	 {
    		 if(array[i]!=array[j])
    		 {
    			 System.out.println(array[j]);
    			
    		 }
    	 }
     }
     
    
    
	}

}
