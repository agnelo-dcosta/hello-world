
import java.util.ArrayList;
import java.util.Collections;

public class MedianFind {

	ArrayList<Integer> tn = new ArrayList<Integer>();
	
	
	double find(){
		
		Collections.sort(tn);
		if(tn.size()%2 == 1) {
		//	double temp = tn.get(tn.size()/2) ;
			return tn.get(tn.size()/2) ;
		}
		  
		else{ 
			//double temp =  (tn.get((tn.size() - 1)/2) + tn.get((tn.size() +1)/2))/2 ;
			return ((double)tn.get((tn.size() - 1)/2) + (double)tn.get((tn.size() +1)/2))/2;	
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFind mf = new MedianFind();
		mf.tn.add(1);
		System.out.println(mf.find());
		mf.tn.add(1);
		System.out.println(mf.find());
		mf.tn.add(7);
		System.out.println(mf.find());
		mf.tn.add(7);
		mf.tn.add(10);
		System.out.println(mf.find());
		mf.tn.add(4);
		System.out.println(mf.find());
	}

}
