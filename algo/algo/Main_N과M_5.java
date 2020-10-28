package algo;
import java.util.*;
import java.io.*;
public class Main_N과M_5 {
	private static int[] arr,save;
	private static boolean[] visit;
	private static int n,m;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		save = new int[m];
		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		perm(0,0);
	}
	private static void perm(int step, int idx) {
		if(step == m) {
			for (int i = 0; i < m; i++) {
				System.out.print((save[i]) + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if(visit[i])continue;
			visit[i] = true;
			save[step] = arr[i];
			perm(step+1,i);
			visit[i] = false;
			
		}
	}//perm 끝
}
