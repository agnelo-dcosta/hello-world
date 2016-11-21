import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayMove {

	public static void arrayMoveLeft(int a[], int d){
		int temp[] = new int[a.length];
		for(int i=0, j =d; i < a.length; i ++)
		{
			temp[i] = a[j];
			j++; j = j % a.length;
			//if(j >= a.length) j = 0;
			System.out.print(" " + temp[i] + " ");
		}
		
	}
	
	public static void arrayMoveLeft( ArrayList<Integer> al, int d){
		List<Integer> temp = new ArrayList<Integer>();
		temp = al.subList(d, al.size());
		List<Integer> temp2 = new ArrayList<Integer>();
		temp2 = al.subList(0, d);
		temp.addAll(temp2);
		
		temp.stream().forEach(t -> {System.out.print(t + " ");});
	}
	
	public static void main(String[] args) {
		Integer a[] = {4,5,6,7,8,9};
        int k = 2;
        
        List<Integer> al = Arrays.asList(a);
        ArrayList<Integer> aI = new ArrayList<Integer>();
        aI.addAll(al);
        arrayMoveLeft( aI , k);
    }

}
