import java.util.ArrayList;

public class HelloWorld {
	
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
	System.out.print(mergeThem);
	
	}

}
