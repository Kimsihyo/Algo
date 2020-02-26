import java.util.*;

public class Main_15820_맞았는데왜틀리죠 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sample_cnt = sc.nextInt();
		int system_cnt = sc.nextInt();
		
		boolean check = true;
		for (int i = 0; i < sample_cnt; i++) {
			int ans = sc.nextInt();
			int minyoung_ans = sc.nextInt();
			if(ans != minyoung_ans) {
				check = false;
				break;
			}
		}
		boolean check2 = true;
		if(check) {
			for (int i = 0; i < system_cnt; i++) {
				int ans = sc.nextInt();
				int minyoung_ans = sc.nextInt();
				if(ans != minyoung_ans) {
					check2 = false;
					break;
				}
			}
		}
		if(check&&check2) {
			System.out.println("Accepted");
		}else if(check && !check2){
			System.out.println("Why Wrong!!!");
		}else {
			System.out.println("Wrong Answer");
		}
	}

}
