package com.abi;

public class StringUtil {

	static int atoi(String str){
		int result = 0;
		int startPointer = 0;
		char[] ca = str.toCharArray();
		boolean negative = false;
		
		if(ca != null && ca.length >1 && ca[0] == '-'){
			negative = true;
			startPointer++;
		}

		for (int i = startPointer; i < ca.length; i++) {

			result = result*10; 

			switch(ca[i]){
			
			case '0':				 
				break;
			case '1':
				result = result + 1; 
				break;
			case '2':
				result = result + 2; 
				break;
			case '3':
				result = result + 3; 
				break;
			case '4':
				result = result + 4; 
				break;
			case '5':
				result = result + 5; 
				break;
			case '6':
				result = result + 6; 
				break;
			case '7':
				result = result + 7; 
				break;
			case '8':
				result = result + 8; 
				break;
			case '9':
				result = result + 9; 
				break;
			default:
				return -1;

			}

		}	
		if(negative)
			result*= -1;

		return result;
	}
	
	static int atoi1(String str){
		int result = 0;
		int sign = 1;
		char[] ca = str.toCharArray();
		int i = 0;
		
		if(str == null || str.length() < 1)
			return -1;
		
		if(ca[0] == '-'){
			sign = -1;
			i++;
		}
		
		for (; i < ca.length; i++) {
			
			int d = ca[i] - '0';
			
			if(d>9 || d<0)
				return -1;
			
			result = result*10 + d;
			
		}
		
		return result*sign;
	}
	
	static String reverseStringWordWise(String input){
		int wordStart = 0;
		int wordEnd = -1;
		char[] inputStr = input.toCharArray();
		for (int i = 0; i < inputStr.length; i++) {			
			if(inputStr[i] == '.'){
				wordEnd = i-1;
				reverseString(inputStr,wordStart,wordEnd);
				wordStart = i+1;
			}			
		}
		reverseString(inputStr,wordStart,input.length()-1);
		reverseString(inputStr,0,input.length()-1);
		
		return new String(inputStr);
		
	}
	
	static void reverseString(char[] inputStr, int start, int end){
		while(start < end){
			swapChar(inputStr,start,end);
			start++;
			end--;
		}
		
	}

	private static void swapChar(char[] inputStr, int start, int end) {
		char temp = inputStr[start];
		inputStr[start] = inputStr[end];
		inputStr[end] = temp;
	}

}
