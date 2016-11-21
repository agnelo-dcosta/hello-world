import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SearchAndSort {

	public int data[];
	class Node { Node(int k, String value){this.k = k; this.value = value;} int k; String value; };
	
	public ArrayList<Node> nodes;
	
	void bubble()
	{	
		int temp;
		for(int i =0; i < data.length; i++)
			for(int j=i+1; j < data.length; j++)
			{
				if(data[i] > data[j])
				{
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
	}
	
	void selection()
	{
		int temp; int pos;
		for(int i=0;i<data.length;i++)
		{
			temp = data[i]; pos = i;
			for(int j=i+1; j < data.length; j++)
			{
				if(temp > data[j])
					{
					pos =j; temp = data[j];
					}
			}
			data[pos] = data[i];
			data[i] = temp;
			
		}
	}
	
	void mergeSort()
	{
		int helper[] = new int[data.length];
		mergeSort(helper,0,data.length  - 1);
	}
	
		void mergeSort(int helper[], int left, int right)
		{
			if(left < right)
			{
				int middle = (right+left)/2;
				mergeSort(helper,left, middle);
				mergeSort(helper, middle + 1 , right);
				merge(helper,left,middle,right);
			}
		}
		
		void merge(int helper[], int left, int middle, int right)
		{
			for(int i = left; i <= right; i ++)
				helper[i] = data[i];
			
			int hL = left;
			int hR = middle + 1;
			int current= left;
			
			while(hL <= middle && hR <= right)
			{
				if(helper[hL] <= helper[hR])
				{
					data[current] = helper[hL];
					hL++;
				}
				else
				{
					data[current] = helper[hR];
					hR++;
				}
				current++;
			}
			int remain = middle - hL;
			for (int i = 0; i<= remain; i++ )
				data[current +i] = helper[hL + i];
		}
	
		int binarySearch(int d)
		{
			for(int i= data.length/2 - 1; i < data.length && i > 0;)
			{
				if (data[i] == d)
					return i;
				else
				{
					if( d > data[i]  )
						i = i + (i+1)/2;
					else
						i = i - (i+2)/2;
				}
			}
			return 100;
		}
	void display()
	{
		System.out.print("\nList:");
		for(int i=0;i < data.length; i++)
			System.out.print(data[i] + " ");
		
		System.out.print("\n Node: ");
		nodes.forEach( (k) -> System.out.print(k.k + ":" + k.value + "   "));
	}
	
	
	void quickSort(ArrayList<Node> list, int left, int right)
	{
		int index = partition(list, left, right);
		if(left < index -1 )
			quickSort(list,left, index - 1);
		if(index < right)
			quickSort(list, index,right);
	}
	
	int partition(ArrayList<Node> list, int left, int right)
	{
		ArrayList<Integer> atemp = new ArrayList<Integer>();
		list.forEach(k -> atemp.add(k.k) );
		int pivot = atemp.get((left + right) / 2);
		
		while(left <= right)
		{
			while((left<atemp.size()) && atemp.get(left)<pivot ) left++;
			
			while(right > 0 && atemp.get(right) > pivot) right--;
			
			if(left <= right)
			{
				final int leftt = left; final int rightt = right; 
				Node tempL = nodes.stream().filter(n -> n.k == atemp.get(leftt)).findAny().orElse(null);
				Node tempR = nodes.stream().filter(n -> n.k == atemp.get(rightt)).findAny().orElse(null);
				
				if(tempL != null && tempR != null)
				{
					int temp; String tempS = new String();
					tempS = tempL.value; temp = tempL.k;
					tempL.k =tempR.k; tempL.value = tempR.value;
					tempR.k = temp; tempR.value = tempS;
					
					left++;
					right--;
				}
			}
		}
		return left;
	}
	
	
	void random()
	{
		data = new int[] {5,68,38,59,1,50,99,23,85,56,87} ;
		nodes = new ArrayList<Node>();
		nodes.add(	new Node(5,"five")); nodes.add( new Node(68, "six-eight")); nodes.add( new Node(38, "three-eight"));
		nodes.add( new Node(59, "five-nine")); nodes.add( new Node(1, "one")); nodes.add( new Node(50, "five-zero"));
		nodes.add( new Node(99, "nine-nine")); nodes.add( new Node(23, "two-three")); nodes.add( new Node(85, "eight-five"));
		nodes.add( new Node(56, "five-six")); nodes.add( new Node(87, "eight-seven"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SearchAndSort s = new SearchAndSort();
		s.data = new int[] {5,68,38,59,1,50,99,23,85,56,87} ;
//		s.display();
//		s.bubble();
//		s.display();
//		s.random();
//		s.selection();
//		s.display();
//		s.random();
//		s.display();
//		s.mergeSort();
//		s.display();
//		System.out.println("find 5 " + s.binarySearch(5));
//		System.out.println("find 10 " + s.binarySearch(10));
//		System.out.println("find 56 " + s.binarySearch(56));
		
		s.random();
		s.display();
		s.quickSort(s.nodes, 0, s.nodes.size() - 1);
		s.display();
	}

}
