package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Babygin2 {
	public static final int N1=1;	// N1은 상수, final은 절대로 값을 바꿀수 없음. 고정된 값
	public        final int N2=2;	// N2는 상수, N1은 static이므로 클레스 에리어에, N2는 Heap에 생성
	public static       int N3=3;	// N3는 전역 변수. N4는 맴버 변수
	public              int N4=4;	// public은 전역, private는 해당 클레스에서만 사용
	
	public static final int N=6;
	public static int[] n=new int[N];
	public static int[] c;
	
	public static boolean solve() {
		int tri=0;
		int run=0;
		for(int i=0;i<c.length;i++) {
			if(c[i]>=3) {
				c[i]-=3;
				tri++;
				i--;
			}
			else if(c[i]>=1 && c[i+1]>=1 && c[i+2]>=1 && i<=7) {
				c[i]--;
				c[i+1]--;
				c[i+2]--;
				run++;
				i--;
			}
		}
		if(tri+run==2)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			c=new int[10];
			for(int i=0;i<N;i++) {
				n[i]=sc.nextInt();
				c[n[i]]++;
			}
			System.out.println("#"+(tc+1)+" "+solve());
		}
			
	}

}
