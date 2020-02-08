import java.util.*;

public class Main_삼구소 {
	static Queue<int[]> select_virus;
	static ArrayList<int[]> total_virus;
	
	static int n,m,map[][] ,dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0}, arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][n];
		total_virus = new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					total_virus.add(new int[] {i,j});
				}
			}
		}
		arr = new int[total_virus.size()];
		comb(0,0);
	}
	static void comb(int step,int idx) {
		if(step == m) {
			
			return;
		}
		for (int i = idx; i < arr.length; i++) {
				arr[step] = i;
				comb(step+1,i+1);
				arr[step] = 0;
		}
	}

}
