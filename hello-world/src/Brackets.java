import java.util.ArrayDeque;

public class Brackets {

public static boolean isBalanced(String expression) {
     
        //char cur = '0';
        ArrayDeque<Character> cur = new ArrayDeque<Character>(); 
	for(int i=0; i < expression.length(); i++)
	{
		char temp = expression.charAt(i);
		switch(temp){
		case '{': cur.push('}'); break;
		case '[': cur.push(']'); break;
		case '(': cur.push(')'); break;
		default : if(cur.isEmpty() || cur.pop() != temp) {return false;}
	
		} 
	}
       
	return cur.isEmpty();
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] b = {"{[()]}","{[(])}","{{[[{()}(())]]}}"};
		System.out.println(b[0] + " " + isBalanced(b[0]));
		System.out.println(b[1] + " " + isBalanced(b[1]));
		System.out.println(b[2] + " " + isBalanced(b[2]));
	}

}
