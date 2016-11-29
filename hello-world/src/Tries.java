import java.util.LinkedList;

public class Tries {

	char root;
	LinkedList<Tries> nodes = new LinkedList<Tries>();
	static int cn;
	String endWord;

	Tries(char n)
	{
		this.root = n;
		endWord = "0";
	}
	
	
	
	void addToTree(Tries t, String nameString){
		if(nameString.length() > 0){
			
				Tries charNode = t.nodes.stream().filter(n -> n.root == nameString.charAt(0)).findAny().orElse(null);
				if (charNode == null)
				{
					charNode = new Tries(nameString.charAt(0));
					charNode.endWord = nameString.substring(1,nameString.length());
					t.nodes.add(charNode);
					for(int i=1; i < nameString.length(); i++){
						Tries temp = new Tries(nameString.charAt(i));
						charNode.nodes.add(temp);
						charNode = temp;
					}
//					Tries temp = new Tries('0');
//					charNode.nodes.add(temp);
					
					return;
				}
				else{
					String temp = charNode.endWord;
					charNode.endWord = "0";
					addToTree(charNode, nameString.substring(1, nameString.length()));
					if(temp.length() > 0 && !temp.equals("0"))addToTree(charNode, temp);
				}
		}
		else {
			t.nodes.add(new Tries('0'));
		}
	
	}
	
	void print(Tries t)
	{
		if (t== null || (t != null && t.root == '0')  ){
			System.out.print(  " EN\n");
			return;
		}
		if(!t.endWord.equals("0")){
			System.out.print(t.root + t.endWord +  " EN\n");
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
		if(par.length() ==0 && (t == null || t.root == '0')  ){ //leaf nodes
			cn++; }
		if(par.length() ==0 && !t.endWord.equals("0")  ){ //leaf nodes
			cn++; return cn;}
		
		if((par.length() ==0 && (t != null) && t.root != '0')){ // word found. find all leaves
			t.nodes.stream().forEach(n -> {if(n!=null)countPar(n,par);});
		
		}
		// hack0erran
		if(par.length() !=0 && t.root != par.charAt(0) && (t.root != '1') ) // char mismatch
			return cn;
		
		if(par.length() !=0 && t.root == par.charAt(0) ){
			for(int i = 1; i < par.length(); i++){
				char tc = par.charAt(i);
				Tries tr = t.nodes.stream().filter(n -> n.root == tc).findAny().orElse(null) ;
				if(tr == null) return cn;
				else{
					t = tr;
				}
			}
			t.nodes.stream().forEach(n -> countPar(n, ""));	
		}
		if(t.root == '1'){
			t.nodes.stream().forEach(n -> {countPar(n,par);});
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
		System.out.println("hak "  + "  " + r.countPar(r, "hak"));
		r.cn = 0;
		System.out.println("Auto "  + "  " + r.countPar(r, "Auto"));
		
//		   if(op.equals("add")) r.addToTree(r,contact);
//           if(op.equals("find")) System.out.println(r.count(contact));
//      }
	}

}
