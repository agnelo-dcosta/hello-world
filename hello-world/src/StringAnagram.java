import java.util.Scanner;

public class StringAnagram {

	public static int numberNeeded(String a, String b){
		int count = 0;
//		StringBuffer a = new StringBuffer(as);
//		StringBuffer b = new StringBuffer(bs);
		char[] ac = a.toCharArray(); 
		
		for(int i = 0 ; i < ac.length ; i ++)
		{
			if(b.contains("" + ac[i]))
			{
				b = b.replaceFirst("" + ac[i], "-");
				a = a.replaceFirst("" + ac[i], "-");
			}
		}
		
		char [] bc = b.toCharArray();
		
		for(int i = 0 ; i < bc.length ; i ++)
		{
			if(a.contains("" + bc[i]) && bc[i] != '-')
			{
				b = b.replaceFirst("" + bc[i], "-");
				a = a.replaceFirst("" + bc[i], "-");
			}
		}
		
		ac = a.toCharArray(); bc = b.toCharArray();
		for(int i = 0 ; i < ac.length ; i ++){ 
			if(ac[i] != '-') count++;
		}
		
		for(int i = 0 ; i < bc.length ; i ++){ 
			if(bc[i] != '-') count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		  
	        String a = "aabbcc";
	        String b = "cab";
	        System.out.println(numberNeeded(a, b));

	}

}
