package 이론.array2;

import java.util.Arrays;
import java.util.Scanner;

// 조합 nCr=nPr/r! ex)6C3=6*5*4/3*2*1=20
public class Combination2 {
	public static int n,r,caseCount,data[];
	
	public static void combination(int start, int flag, int count) {
		if(count==r) {
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		for(int i=start;i<=n;i++) {
			if((flag&1<<i)==0) {	// 중복제거
				data[count]=i;
				combination(i,flag|1<<i,count+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=5; // n=sc.nextInt();
		r=3; // r=sc.nextInt();
		data=new int[r];
		combination(1,0,0);
		System.out.println(caseCount);
		sc.close();
	}

}
