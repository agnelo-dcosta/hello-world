import java.util.ArrayList;

public class HelloWorld {
	
	public String joinWords(String[] words) { 
		StringBuilder sentence = new StringBuilder();
		for (String w : words) {
			sentence.append(w);
		}
		return sentence.toString(); 
	}
	
	Boolean checkDupInString(String word){
		char [] letters = word.toCharArray();
		int [] letterCount = new int[200];
		
		char t;
		for(int i=0; i < letters.length; i++)
		{
			for (int j=1;j < letters.length; j++)
			{
				if(letters[i] == letters[j] && i != j )
				{
					//return false;
				}
			}
		}
		
		
		for(int i=0; i < letters.length; i++)
		{
			letterCount[letters[i] ] ++;
		}
		
		for(int i:letterCount)
		{
			if (i > 1)
				return false;
		}
		
		return true;
	}
	
	
	public static ArrayList<String> merge(String[] words, String[] more) { 
	
		ArrayList<String> sentence = new ArrayList<String>(); 
		for (String w : words) sentence.add(w);
		for (String w : more) sentence.add(w);
		return sentence;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Hello world");
	String[] words = {"HI", "hello"};
	String[] more = {"HI again", "hello again "};
	
	ArrayList<String> mergeThem = merge(words, more);
	System.out.println(mergeThem);
	
	HelloWorld hi = new HelloWorld();
	
	String [] mergeThemString = mergeThem.stream().toArray(String[]::new);
	String sb = hi.joinWords(mergeThemString);
	System.out.println("---- dup check -------");
	System.out.println("Helo  " + hi.checkDupInString("Helo"));
	System.out.println("Hello  " + hi.checkDupInString("Hello"));
	System.out.println("checkDupInString  " + hi.checkDupInString("checkDupInString"));
	}

}
