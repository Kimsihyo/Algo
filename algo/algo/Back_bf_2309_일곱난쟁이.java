package algo;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Back_bf_2309_일곱난쟁이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] num = new int[9];
		for (int i = 0; i < 9; i++) {
			num[i] = sc.nextInt();
			sum += num[i];
		}
		int ans = 0;
		Arrays.sort(num);
		int idx1 = 0, idx2 = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if ((sum - (num[i] + num[j])) == 100) {
					idx1=i;
					idx2=j;
				}

			}

		}
	//	System.out.println(idx1 + " "+ idx2);
		for(int i=0;i<9;i++){
			if(idx1!=i&&idx2!=i){
				System.out.println(num[i]);
			}
			else continue;
		}
	}

}
