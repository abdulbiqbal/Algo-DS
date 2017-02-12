package com.abi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		/*System.out.println((StringUtil.atoi1("2")));
		System.out.println((StringUtil.atoi1("123")));
		System.out.println((StringUtil.atoi1("21a")));
		System.out.println((StringUtil.atoi1("-12")));
		System.out.println((StringUtil.atoi1("1-2")));*/
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		
		int T = Integer.parseInt(line);
		
		while(T-- > 0){		
			System.out.println(StringUtil.reverseStringWordWise(br.readLine()));
		}*/
		
		System.out.println(StringUtil.reverseStringWordWise("i.like.this.program.very.much"));

	}

}
