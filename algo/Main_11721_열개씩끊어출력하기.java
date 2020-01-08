import java.io.*;

public class Main_11721_열개씩끊어출력하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			if(i%10==9) {
				System.out.println();
			}
		}
		br.close();
	}

}
