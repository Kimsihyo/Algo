package 이론.array2;

import java.util.Arrays;
import java.util.Scanner;

// 조합 nCr=nPr/r! ex)6C3=6*5*4/3*2*1=20
public class Combination {
	public static int n,r,caseCount,data[];
	public static void Combination(int before,int count) {
		if(count==r) {
			for(int i=0;i<r;i++) {
				for(int j=i+1;j<r;j++) {
					if(data[i]==data[j]) return;
				}
			}
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		else{
			for(int i=before;i<=n;i++) {
				data[count]=i;
				Combination(i,count+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=6; // n=sc.nextInt();
		r=3; // r=sc.nextInt();
		data=new int[r];
		Combination(1,0);
		System.out.println(caseCount);
		sc.close();
	}

}
