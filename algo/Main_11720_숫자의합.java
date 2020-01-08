import java.io.*;
public class Main_11720_숫자의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String num = br.readLine();
		int sum =0;
		for (int i = 0; i < n; i++) {
			sum += (num.charAt(i) -'0');
		}
		System.out.println(sum);
		br.close();
	}
}
