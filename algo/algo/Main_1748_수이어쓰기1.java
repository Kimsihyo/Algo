package algo;
import java.io.*;
import java.util.*;


public class Main_1748_수이어쓰기1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double n = Integer.parseInt(br.readLine());
		double a = 1;
		double ans = 0;
		for (int i=0;; i++) {
			//i자리 숫자
			if(i>=1) {
				a = Math.pow(10, i);
			}
			else {
				a = i+1;
				
			}
			if(n>=a*9) {
				n -= a*9;
				ans += a*9*(i+1);
			}
			else {
				ans += n*(i+1);
				break;
			}
		}
		System.out.println((int)ans);
		
	}

}
