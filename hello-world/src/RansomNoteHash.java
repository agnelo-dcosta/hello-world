import java.util.HashMap;
import java.util.Map;

public class RansomNoteHash {

	boolean noteFind(String[] m, String[] r)
	{
		Map<String,Integer> mag = new HashMap<String,Integer>();
		for(int i=0; i < m.length ; i++){
			if(mag.containsKey(m[i])){
				Integer count = mag.get(m[i]);
				mag.put(m[i], ++count);
			}
			else{
				mag.put(m[i], 1);
			}
		}
		
		for(int i=0; i < r.length; i++){
			if(mag.containsKey(r[i])){
				Integer count = mag.get(r[i]);
				if(count == 0){
					return false;
				}
				else{
					mag.put(r[i], --count);
				}
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] m = {"Hi","Agnelo","hola","ransom","note"};
		String [] r = {"ransom","hola","ransom"};
		System.out.println(new RansomNoteHash().noteFind(m,r));
	}

}
