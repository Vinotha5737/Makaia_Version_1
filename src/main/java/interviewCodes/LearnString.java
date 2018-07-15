package interviewCodes;

public class LearnString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="Vinotha";
		//method 1
		
		char[] n = name.toCharArray();
		for(int i=n.length-1;i>=0;i--)
		{
			System.out.println(n[i]);
		}
		
		//method 2
		
		for(int i=n.length-1;i>=0;i--)
		{
			System.out.println(name.charAt(i));
		}
		//method 3
		
		StringBuilder sb=new StringBuilder(name);
		StringBuilder reverse=sb.reverse();
		System.out.println(reverse);
        //for each
		for (char c : n) {
			System.out.println(c);
		}
		
	    //To get the memory location of the string
		System.out.println(name.hashCode());
	}

}
