package algo;
import java.util.*;
import java.io.*;
public class Main_N과M_9 {
	private static int[] arr,save;
//	private static boolean[] visit;
	private static int n,m;
	static Set<int[]> set;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		save = new int[m];
//		visit = new boolean[n];
		set = new HashSet<int[]>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0,0);
		int size = set.size();
		for (int [] a : set) {
			System.out.println(Arrays.toString(a));
		}
	}
	private static void perm(int step, int idx) {
		if(step == m) {
			set.add(save);
			return;
		}
		for (int i = idx; i < n; i++) {
//			if(visit[i])continue;
//			visit[i] = true;
			save[step] = arr[i];
			perm(step+1,i);
//			visit[i] = false;
			
		}
	}//perm 끝
}
