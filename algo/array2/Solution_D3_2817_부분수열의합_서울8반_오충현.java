package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_2817_부분수열의합_서울8반_오충현 {
	public static int[] data;
	public static int N, K, cnt;
	
	public static void solve(int sum,int pos) {
		if(sum>K) return;
		if(sum==K) {
			cnt++;
			return;
		}
		if(pos>N-1)
			return;
		solve(sum,pos+1);
		solve(sum+data[pos],pos+1);
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/2817_부분수열의합.txt"));
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			N=sc.nextInt();
			data=new int[N];
			K=sc.nextInt();
			for(int i=0;i<N;i++)
				data[i]=sc.nextInt();
			
			cnt=0;
			solve(0,0);
			System.out.println("#"+(tc+1)+" "+cnt);
		}
	}

}
