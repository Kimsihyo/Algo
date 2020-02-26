import java.io.*;
import java.util.*;

public class Main_5597_과제안내신분 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[31];
		arr[0] = true;
		for (int i = 1; i <= 28; i++) {
			int number = 0;
			if(sc.hasNext()) {
				number =sc.nextInt();
			}
			arr[number] = true;
		}
		
		for (int i = 1; i <= 30; i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
		
	}

}
