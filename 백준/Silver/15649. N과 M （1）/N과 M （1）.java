import java.util.*;

public class Main {

	static int[] save;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		save = new int[r];
		chk = new boolean[n];
		
		make(0,0);
	}
	
	static void make(int idx, int cnt) {
		if(cnt == save.length) {
			for(int k=0; k<save.length; k++) {
				System.out.print(save[k] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<chk.length; i++) {
			if(!chk[i]) {
				chk[i] = true;
				save[cnt] = i+1;
				make(i,cnt+1);
				chk[i] = false;
			}
			
		}
	}

}
