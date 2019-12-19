package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10971_외판원순회2_순열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		for(int i = 0; i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j] = sc.nextInt();
			}
		}
		int[] d= new int[n];
		for(int i = 0; i<n;i++){
			d[i] = i;
		}
		int min = Integer.MAX_VALUE;
		do{
			int sum = 0;
			if(d[0]!=0)break;
			boolean ok = true;
			for(int i = 0; i<n-1;i++){
				if(a[d[i]][d[i+1]]==0){
					ok = false;
				}else{
					sum+=a[d[i]][d[i+1]];
				}
			}
			if(ok && a[d[n-1]][d[0]] != 0){
				sum += a[d[n-1]][d[0]];
				if(min > sum){
					min = sum;
				}
			}
		}while(permutation(d));
		System.out.println(min);
	}
	public static boolean permutation(int[] d){
		int i = d.length-1;
		while(i > 0 && d[i-1] >=d[i]){
			i-=1;
		}
		if(i<=0) return false;
		
		int j = d.length-1;
		while(d[j]<=d[i-1]){
			j-=1;
		}
		int temp = d[i-1];
		d[i-1] = d[j];
		d[j] =temp;
		j=d.length-1;
		while(i<j){
			temp = d[i];
			d[i] = d[j];
			d[j] = temp;
			i+=1;
			j-=1;
		}
			return true;	
	}
}
