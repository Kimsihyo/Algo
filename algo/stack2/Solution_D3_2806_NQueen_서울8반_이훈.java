package stack2;

import java.util.Scanner;

public class Solution_D3_2806_NQueen_서울8반_이훈 {
	public static int N;
	public static int[] col;
	public static int result;
	public static boolean promising(int i) {
		for(int j=0; j<i; j++) {
			if (col[j]==col[i] || Math.abs(col[i]-col[j])==(i-j)) return false;
		}
		
		return true;
	}
	public static void nqueen(int i) {
		if(i==N) {
			result = result+1;
		}else {
			for(int j=0; j<N ; j++) {
				col[i]=j;
				if(promising(i)) nqueen(i+1);
			}
		}
	}

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
        int testCase=sc.nextInt();
        for(int tc=1; tc<=testCase; tc++){
        N = sc.nextInt();
		col  = new int[N];
		nqueen(0);
        System.out.println("#"+tc+" "+result);
            result=0;
        }
		
		
		
		
	}
}
