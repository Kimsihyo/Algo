package algo;
import java.io.*;
import java.util.*;

public class Solution_모의SW역량테스트_보물상자비밀번호 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1. 1차원 배열로 값 받기 n/4개로 끊어서 값 확인
		//2. 1칸씩 시계방향으로 회전하기 
		//3. 3개씩 끊어서 값 확인하기 + 중복 확인
		//4. 2-3번 반복
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());//k번째 배열 확인
			String number = br.readLine();
			//1. 1차원 배열로 값 받기 n/4개로 끊어서 값 확인
			int cut = n/4;
			char[] arr = new char[number.length()];
			arr = number.toCharArray(); 
			
			StringBuilder sb = new StringBuilder();
			long[] arr2 = new long[4];
			for (int i = 0; i < number.length(); i++) {
				for (int j = 0; j < cut; j++) {
					sb = sb.append(arr[i+j]);
				}
				System.out.println(sb.toString());
				String s = sb.toString();
				arr2[i] = Integer.parseInt(s);
				System.out.println(arr[i]);
				sb.delete(0, cut);
				i+=2;
			}
//			System.out.println(Arrays.toString(arr2));
			

			
			
			
			
			
		}
	}

}
