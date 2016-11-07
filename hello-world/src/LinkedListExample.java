
public class LinkedListExample {

	class Node {
		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}

		void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		Node removeNode(int d)
		{
			Node n = this;
			Node pri = this;
			if(n.data == d) { return n.next; }
			else
			{
				while(d != n.data && n != null)
					pri = n; n = n.next;
				
				if (n != null)
					pri.next = n.next;
				return this;
			}
		}
		void printNodes()
		{
			Node n = this;
			System.out.println("...");
			do {
				System.out.print(" " + n.data + " ");
				n = n.next;
			} while (n != null);
		}
		void removeDups()
		{
			Node n = this;
			Node nextNode = this;;
			while(n!=null)
			{
				nextNode = n.next;
				Node pri = n;
				while(nextNode != null ) {
				if (n.data == nextNode.data) {
					if  (nextNode.next != null) pri.next = (nextNode.next);
					else pri.next = null;
				}
				pri = nextNode;
				nextNode = nextNode.next;
				}
				n = n.next;
			}
		}

	}
	
	void testNode()
	{
		Node n = new Node(5);
		n.appendToTail(10); n.appendToTail(15); n.appendToTail(20);n.appendToTail(10); n.appendToTail(15); n.appendToTail(20);
		n.printNodes();
		n.removeDups(); n.printNodes();
		n.appendToTail(10); n.appendToTail(15); n.appendToTail(20);n.appendToTail(10); n.appendToTail(5); n.appendToTail(5);
		n.printNodes();
		n.removeDups(); n.printNodes();
		//		n = n.removeNode(5);n.printNodes();
//		n.appendToTail(5); n = n.removeNode(15);n.printNodes();
//		n.appendToTail(15); n = n.removeNode(15);n.printNodes();
		
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListExample ll = new LinkedListExample();
		ll.testNode();

	}

}
