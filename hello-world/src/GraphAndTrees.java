import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAndTrees {

	class Node {
		public String name;
		public Node[] children;
		int visited = 0;
	}

	class Graph {
		public Node[] nodes;
	}

	void graphTest()
	{
		Graph gr = new Graph(); gr.nodes = new Node[10];
		Node a = new Node(); Node b = new Node(); Node c = new Node(); Node d = new Node(); 
		Node e = new Node(); Node f = new Node(); Node g = new Node(); Node h = new Node();
		Node i = new Node(); Node j = new Node();
		
		a.name = "a"; b.name = "b"; c.name = "c"; d.name = "d"; e.name = "e"; f.name = "f"; 
		g.name = "g"; h.name = "h"; i.name = "i"; j.name = "j"; 
		
		gr.nodes[0] = a; gr.nodes[1] = b; gr.nodes[2] = c; gr.nodes[3] = d; gr.nodes[4] = e; 
		gr.nodes[5] = f; gr.nodes[6] = g; gr.nodes[7] = h; gr.nodes[8] = i; gr.nodes[9] = j; 
		for(int t=0;t < gr.nodes.length; t++)
			gr.nodes[t].children = new Node[10]; 
		
		a.children[0] = b; a.children[1] = c; 
		b.children[0] = d; b.children[1] = e;
		c.children[0] = d; 
		d.children[0] = e; d.children[1] = g;
		e.children[0] = h; e.children[1] = i;
		g.children[0] = j; 
		
		graphVisit(a);
		
		resetVisit(gr) ;
		
		search(a);
	}
	
	void graphVisit(Node root)
	{
		if( root == null || root.visited == 1)
			return;
		else
		{
			
			for(int i= 0; i < root.children.length; i++)
			{
				graphVisit(root.children[i]);
			}
			System.out.println(root.name);
			root.visited = 1;
		}
	}
	
		void search(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		root.visited = 1;
		queue.add(root);  
		System.out.println("BFS");
		while(!queue.isEmpty() )
		{
			Node r = queue.remove();
			System.out.println(r.name);
			for(int i=0;i < r.children.length; i++)
			{
				if(r.children[i] != null && r.children[i].visited == 0)
				{
					r.children[i].visited = 1;
					queue.add(r.children[i]);
				}
			}
		}
		}

		
	void resetVisit(Graph g)
	{
		for(int i =0;i < g.nodes.length; i++)
		{
			g.nodes[i].visited = 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAndTrees gt = new GraphAndTrees();
		gt.graphTest();
		
		
	}

}
