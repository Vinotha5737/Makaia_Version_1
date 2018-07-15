package interviewCodes;

public class Replace2Space {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String input="Hi  Welcome back  utto my world";
     String output=input.replaceAll("\\s{2}", " ");
     System.out.println(output);
	}

}
