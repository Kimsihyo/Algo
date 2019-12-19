package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1000_A더하기B_2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		System.out.println(A + B - 2);

		br.close();
	}

}
