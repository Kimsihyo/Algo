import java.lang.reflect.Array;
import java.util.Scanner;

public class Main_1904_01타일 {
	static int cnt, arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = 3;
		}
		cnt = 0;
		go(n,0);
		System.out.println(cnt);
		sc.close();
	}
	static void go(int nn, int next) {
		
		
		if( next == nn ){
			for (int i = 0; i < nn-1; i++) {
				if(arr[i] == 1 && arr[i+1] == 0) {
					if(i+2==nn && arr[i+1] == arr[i+2]) {
						cnt++;
						break;
					}else if(i+2 < nn) {
						break;
					}
				}else if(arr[i] == 0 && arr[i+1] == 0){
					cnt++;
					break;
				}else if(arr[i] == 1 && arr[i+1] == 1) {
					cnt++;
					break;
				}else if(arr[i] == 0 && arr[i+1]==1) {
					if(i+2 == nn && arr[i+1] == 0 ) {
						cnt++;
						break;
					}else if(i+2 < nn) {
						break;
					}
				}
			}
			return;
		}
		for (int i = next; i < nn; i++) {
			arr[i] = 1;
			go(nn, next+1);
			arr[i] = 0;
			go(nn, next+1);
		}
	}
}
