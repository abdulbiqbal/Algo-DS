import java.io.*;
import java.util.*;

public class Problem1 {

	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String res;
        int numberArray_size = 0;
        numberArray_size = Integer.parseInt(in.nextLine().trim());

        int[] numberArray = new int[numberArray_size];
        for(int i = 0; i < numberArray_size; i++) {
            int numberArray_item;
            numberArray_item = Integer.parseInt(in.nextLine().trim());
            numberArray[i] = numberArray_item;
        }

        res = findQualifiedNumbers(numberArray);
        bw.write(res);
        bw.newLine();

        bw.close();
    }
	
	/*
     * Complete the function below.
     */
    static String findQualifiedNumbers(int[] numberArray) {
		//StringBuffer sb = new StringBuffer();
		List<Integer> res = new ArrayList<Integer>(){
			
			
			public String toString(){
				int i=0;
				if(super.size() > 0){
					StringBuffer sb = new StringBuffer();
					for (Integer e : this) {						
						sb.append(e);
						i++;
						if(i < size())
							sb.append(",");
					}
					return sb.toString();
				}else
					return "-1";
			}
		};
			
		
		
		for (int i = 0; i < numberArray.length; i++) {
			if(contains123(numberArray[i])){
				res.add(numberArray[i]);
			}
		}
		
		Collections.sort(res);
		
		return res.toString();

    }

	private static boolean contains123(int i) {
		int d = 0;
		boolean have1 = false;
		boolean have2 = false;
		boolean have3 = false;
		while(i > 0){
			d = i % 10;
			i=i/10;
			
			switch(d){
				case 1: have1 = true;
						break;
				case 2: have2 = true;
						break;
				case 3: have3 = true;
						break;
			}
			
		}		
		
		return have1&&have2&&have3;
	}
}
