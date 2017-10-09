import java.io.*;
import java.util.*;

public class Solution2 {

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

		int res;
		String pattern;
		try {
			pattern = in.nextLine();
		} catch (Exception e) {
			pattern = null;
		}

		res = findPossibleSmallestNumberMatchingPattern(pattern);
		bw.write(String.valueOf(res));
		bw.newLine();

		bw.close();
	}

	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		char[] arr = pattern.toCharArray();
		int noOfNextD = 0;
		int curr_max = 0;
		int res =0;

		// Initialize last_entry (Keeps track for
		// last printed digit)
		int last_entry = 0;

		int j = 0;

		for (int i = 0; i < arr.length; i++) {


			switch(arr[i])
			{
			case 'N':
				// If letter is 'N'

				// Calculate number of next consecutive D's
				// available
				j = i;
				while (arr[j] == 'M' && j < arr.length)
				{
					noOfNextD++;
					j++;
				}

				if (i==0)
				{
					curr_max = noOfNextD + 2;

					// If 'N' is first letter, print incremented
					// sequence from 1


					//cout << " " << ++last_entry;
					++last_entry;
					res = res * 10 + last_entry;

					//cout << " " << curr_max;
					res = res * 10 + curr_max;

					// Set max digit reached
					last_entry = curr_max;
				}
				else
				{
					// If not first letter

					// Get next digit to print
					curr_max = curr_max + noOfNextD + 1;

					// Print digit for I
					last_entry = curr_max;
					//cout << " " << last_entry;
					res = res * 10 + last_entry;
				}

				// For all next consecutive 'M' print 
				// decremented sequence
				for (int k=0; k<noOfNextD; k++)
				{
					//cout << " " << --last_entry;
					--last_entry;
					res = res * 10 + last_entry;
					i++;
				}
				break;

				// If letter is 'M'
			case 'M':
				if (i == 0)
				{
					// If 'M' is first letter in sequence
					// Find number of Next D's available
					j = i;
					while (arr[j] == 'M' && j < arr.length)
					{
						noOfNextD++;
						j++;
					}

					// Calculate first digit to print based on 
					// number of consecutive D's
					curr_max = noOfNextD + 2;

					// Print twice for the first time
					//cout << " " << curr_max << " " << curr_max - 1;
					res = res * 10 + curr_max;
					res = res * 10 + curr_max-1;

					// Store last entry
					last_entry = curr_max - 1;
				}
				else
				{
					// If current 'M' is not first letter

					// Decrement last_entry
					//cout << " " << last_entry - 1;
					res = res * 10 + (last_entry - 1);
					last_entry--;
				}
				break;
			}
		}
		return res;
	}

	private static boolean isAlldigitConsumed(boolean[] digits) {
		for (boolean b : digits) {
			if(b == false)
				return false;
		}
		return true;
	}

}
