import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class binaryString {

	
	static int count(String s) {
		
		//getAll(s);
		//System.out.println(getAll(s));
		
		return getAll(s);
    }
	
	static int getAll( String s){
		Set<String> set = new HashSet<String>();
		int validCount = 0;
		
		for(int i=0; i < s.length() - 1; i++){
			char cur = s.charAt(i);
			int change = 0; 
			int count[] = new int[2];
			count[cur-'0']++;
			for(int j= i+1; j < s.length() && change < 2; j++){
				
				if(cur != s.charAt(j)){
					change++ ;
					cur = s.charAt(j); 
				}
				count[s.charAt(j)-'0']++;
				
				String temp = s.substring(i, j + 1);
				if(change < 2 && count[0]==count[1]){
					validCount++;
					System.out.println("...." + temp + " count " + count[0] + "  " + count[1]);
				}
			}
		}
		//all.stream().forEach(n -> System.out.println(n));
		return validCount;
	}
	
	static boolean checkValid(String temp, Set<String> set){
		if(set.contains(temp)){
			return true;
		}
		int count0 = 0; int count1= 0;
		if(temp.charAt(0) == '0') ++count0;
		
		if(temp.charAt(0) == '1') ++count1;
		
		for(int i=1; i< temp.length() ; i ++ )
		{
				
			if(temp.charAt(i) == '0') ++count0;
			
			if(temp.charAt(i) == '1') ++count1;
		}
		if ( count0 == count1) {
			set.add(temp);
			return true;
		}
		else return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		count("00110");
	}

}
