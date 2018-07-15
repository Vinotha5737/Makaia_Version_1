package interviewCodes;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrintOccurances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		String company="Alight Solutions";
		company=company.toLowerCase();
		company=company.replaceAll(" ", "");
		System.out.println(company);
		char[] charArray = company.toCharArray();
		Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		for (char c : charArray) {
			System.out.println(c);
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
				map.put(c, 1);
		}
		System.out.println(map);
	}

}
