import java.util.HashSet;
import java.util.Set;

public class FindAnagram {

	int[] findMatch(String hay, String nee){
		int match [] = new int[hay.length()];
		
		
		return match;
	}
	
	void findAna(String nee){
		Set set = new HashSet<String>();
		permutation("", nee, set);
		
		set.stream().forEach(n -> {System.out.println(n);} );
		//return set;
		return ;
	}
	
	private static void permutation(String prefix, String str, Set set) {
	    int n = str.length();
	    if (n == 0) set.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + "" + str.substring(i+1, n), set);
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAnagram fa = new FindAnagram();
		fa.findAna("abc");
		
	}

}
