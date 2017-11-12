package com.abi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sample {
	
	static int[][] arr;
	public static void main (String[] args){
	    Scanner in=new Scanner(System.in);
	    int t=in.nextInt();
	    in.nextLine();
	    while(t-->0){
	        int n=in.nextInt();
	        int x=in.nextInt();
	        int y=in.nextInt();
	        in.nextLine();
	        arr=new int[n][3];
	        
	        for(int i=0;i<n;i++)
	        arr[i][1]=in.nextInt();
	        
	        in.nextLine();
	        for(int i=0;i<n;i++)
	        arr[i][2]=in.nextInt();
	        
	        System.out.println(maxTIP(n,x,y));
	        if(in.hasNextLine())
	        in.nextLine();
	    }
	}
	public static int maxTIP(int n,int x,int y){
	    for(int i=0;i<n;i++)
	    arr[i][0]=Math.abs(arr[i][1]-arr[i][2]);
	    
	    Arrays.sort(arr,new Comparator<int[]>(){
	        @Override
	        public int compare(int[] o1,int[] o2){
	            return -1*Integer.compare(o1[0],o2[0]);
	        }
	    });
	    
	  //  System.out.println(Arrays.deepToString(arr));
	    
	    int ans=0;
	    for(int i=0;i<n;i++){
	        
	        if((x>0 && arr[i][1]>arr[i][2]) || y==0){
	            ans+=arr[i][1];
	            x--;
	        }
	        
	       else{
	            ans+=arr[i][2];
	            y--;
	        }
	    }
	    return ans;
	}

}
