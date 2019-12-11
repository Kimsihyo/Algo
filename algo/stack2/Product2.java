package stack2;

import java.util.Arrays;
import java.util.Scanner;

// 중복순열 nPIr=n^r ex)6PI3=6*6*6=216
public class Product2 {
	public static int n,r,caseCount,data[];
	public static void product(int count) {
		if(count==r) {
			int sum=0;
			for(int i=0; i<2; i++) {
				sum+=data[i];
			}
			if(sum!=4)
				return;
			
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		else{
			for(int i=1;i<=n;i++) {
				data[count]=i;
				product(count+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=4; // n=sc.nextInt();
		r=2; // r=sc.nextInt();
		data=new int[r];
		product(0);
		System.out.println(caseCount);
		sc.close();
	}

}
