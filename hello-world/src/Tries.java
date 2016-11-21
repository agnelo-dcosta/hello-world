import java.util.LinkedList;

public class Tries {

	char root;
	LinkedList<Tries> nodes = new LinkedList<Tries>();
	static int cn;
	String endWord;

	Tries(char n)
	{
		this.root = n;
	}
	
	
	
	void addToTree(Tries t, String nameString){
		if(nameString.length() > 0){
			
				Tries charNode = t.nodes.stream().filter(n -> n.root == nameString.charAt(0)).findAny().orElse(null);
				if (charNode == null)
				{
					charNode = new Tries(nameString.charAt(0));
					charNode.endWord = nameString;
					t.nodes.add(charNode);
					return;
				}
				String temp = charNode.endWord;
				charNode.endWord = null;
				addToTree(charNode, nameString.substring(1, nameString.length()));
				if(temp != null){
					addToTree(t, temp);
					//addToTree(charNode, temp);
				}
		}
		else {
			t.nodes.add(new Tries('0'));
		}
	
	}
	
	void print(Tries t)
	{
		if (t== null || (t != null && t.root == '0') || ( t != null && t.endWord != null)){
			System.out.print("" + t.endWord + "");
			System.out.print(" EN\n");
			return;
		}
		
		else{
			System.out.print("" + t.root + "");
			t.nodes.stream().forEach(n -> print(n));
		}
		return;
	}
	
	
	
	int countPar(Tries t,String par)
	{
		if(par.length() ==0 && (t == null || t.root == '0') ){
			cn++; return cn; }
		
		if(t !=null && t.endWord != null && t.endWord.contains(par)){
			cn++; return cn;
		}
		
		if((par.length() ==0 && (t != null)) ||  t.root == '1'){
			t.nodes.stream().forEach(n -> {countPar(n,par);});
		}
		
		if(par.length() !=0 && t.root != par.charAt(0) )
			return cn;
		
		if(par.length() !=0 && t.root == par.charAt(0) ){
			t.nodes.stream().forEach(n -> {countPar(n,par.substring(1, par.length()));});
		}
		
		
		return cn;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name1 = "hack";
		String name2 = "ackerrank";
		String name3 = "hackerrank";
		String find1 = "hac";
		String find2 = "ackerrank";
		Tries r = new Tries('1');
		//System.out.println("a " + r.getChar('a') + " m " + r.getChar('m') + " z " + r.getChar('z'));
		r.addToTree(r, "hack");
		r.addToTree(r, "ackerrank"); 
		r.addToTree(r, "hackerrank");
		r.addToTree(r, "Auto-generated method stub"); 
		r.addToTree(r, "t.nodes.stream().forEach");
		r.addToTree(r, "Auto-method stub"); 
		r.addToTree(r, "t.nodes.().forEach");
		r.addToTree(r, "generated  stub");
		r.addToTree(r, ".stream().forEach");
		
		r.print(r);
		
		r.cn = 0;
		System.out.println("hac "  + "  " + r.countPar(r, "hac"));
		r.cn = 0;
		System.out.println("ackerrank "  + "  " + r.countPar(r, "ackerrank"));
		r.cn = 0;
		System.out.println("Auto "  + "  " + r.countPar(r, "Auto"));
		
//		   if(op.equals("add")) r.addToTree(r,contact);
//           if(op.equals("find")) System.out.println(r.count(contact));
//      }
	}

}
