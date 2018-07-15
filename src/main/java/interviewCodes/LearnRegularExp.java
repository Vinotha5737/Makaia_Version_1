package interviewCodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegularExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     //**************************************Method 1 ******************************
	 //Problem No1
     String Company1="Alight0665737%$^%$^";
     System.out.println(Company1.replaceAll("[0-9{~!@#$%^&*()_+|}{:;'?/.><,`}]", ""));
     
     //Problem No2
     String company2="Alight0665737%$^%$^";
     System.out.println(company2.replaceAll("[A-Za-z{~!@#$%^&*()_+|}{:;'?/.><,`}]",""));
     
     //Problem No3
     String company3="Alight0665737%$^%$^";
     System.out.println(company3.replaceAll("[A-Za-z0-9]", ""));
     System.out.println(company3.replaceAll("\\w", ""));
     //******************************Method2 ********************************************
  
     
     
	}

}
