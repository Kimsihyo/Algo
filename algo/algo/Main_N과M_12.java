package algo;
import java.util.*;
import java.io.*;
public class Main_N과M_12 {
	private static int[] arr,save;
	private static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		save = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0,0);
		
	}//main 끝
	private static void perm(int step, int idx) {
		if(step == m) {
			for (int k : save) {
				System.err.print(k+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			save[idx] = arr[step];
			perm(step+1,i+1);
		}
	}//perm 끝
}
