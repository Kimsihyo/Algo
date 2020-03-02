import java.io.*;
import java.util.*;

public class Solution_D5_최적경로 {
	static int ans, customerCount,company[],home[],customer[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			customerCount = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			home = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			customer = new int[customerCount][2];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < customerCount; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			solution(company[0],company[1],0,0,new boolean[customerCount]);
			
			
			System.out.println("#"+tc+" "+ ans);
		}//tc 끝
		
	}//main 끝
    public static void solution(int cury, int curx, int len, int idx, boolean[] visit) {
        if (ans < len) {
            return;
        }
        if (idx == customerCount) {
            len += Math.abs(cury - home[0]) + Math.abs(curx - home[1]);
            ans = Integer.min(ans, len);
            return;
        }
 
        for (int i = 0; i < customerCount; i++) {
            if (!visit[i]) {
                int tmp = Math.abs(cury - customer[i][0]) + Math.abs(curx - customer[i][1]);
                visit[i] = true;
                solution(customer[i][0], customer[i][1], tmp + len, idx + 1, visit);
                visit[i] = false;
            }
        }
    }
}
