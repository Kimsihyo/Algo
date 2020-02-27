package algo;
import java.util.Scanner;

public class Main_16917_양념반후라이드반 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();//양념
		int b = sc.nextInt();//후라이드
		int c = sc.nextInt();//반반
		
		int x = sc.nextInt();//양념 목표 마리
		int y = sc.nextInt();//후라이드 목표
		
		int banban_cnt = 0;//2배 해줘야함
		int ans = Integer.MAX_VALUE;
		while(true) {//반반기준
			
			int a_cnt = x-(banban_cnt/2);
			int b_cnt = y-(banban_cnt/2);
			if(a_cnt <=0 ) {
				a_cnt =0;
			}
			if(b_cnt <= 0) {
				b_cnt = 0;
			}
			int a_price = a*a_cnt;
			int b_price = b*b_cnt;
			int c_price = c*banban_cnt;
			
			int sum = a_price+b_price+c_price;
			
			ans = Math.min(ans, sum);
			
			if((banban_cnt/2)>=x
					&&(banban_cnt/2)>=y) {
				break;
			}
			banban_cnt+=2;
			
		}
		System.out.println(ans);
		
	}

}
