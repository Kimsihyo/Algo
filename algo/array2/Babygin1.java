package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Babygin1 {
	public static final int N=6;
	public static int[] n=new int[N];
	public static int[] a=new int[N];
	public static int caseCount;

	public static boolean permutation(int flag, int count) {
		if(count==N) {
//			System.out.println(Arrays.toString(a));
			int tri=0;
			int run=0;
			
//			for(int i=0;i<2;i++) {
//				if((a[i*3]==a[i*3+1] && a[i*3+1]==a[i*3+2]))
//					tri++;
//				if((a[i*3]+1==a[i*3+1] && a[i*3+1]+1==a[i*3+2]))
//					run++;
//			}
			
			if((a[0]==a[1] && a[1]==a[2]))
				tri++;
			if((a[3]==a[4] && a[4]==a[5]))
				tri++;
			if((a[0]+1==a[1] && a[1]+1==a[2]))
				run++;
			if((a[3]+1==a[4] && a[4]+1==a[5]))
				run++;
			
			if(tri+run==2)
				return true;
			else
				return false;
		}
		//	순열을 구함
		for(int i=0;i<N;i++) {
			if((flag&(1<<i))==0) {
				a[count]=n[i];
				if(permutation(flag|(1<<i), count+1))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			for(int i=0;i<N;i++) {
				n[i]=sc.nextInt();
			}
			System.out.println("#"+(tc+1)+" "+permutation(0,0));
		}
		sc.close();
	}

}
