import java.util.*;

public class Solution_모의SW역량테스트_벌꿀채취 {
	static int map[][],n,m,c,worker1[][],worker2[][],work1_max, work2_max;
	
	static boolean visit[][],chk1[],chk2[];
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			visit = new boolean[n][n];
			m = sc.nextInt();//2
			c = sc.nextInt();//10
			work1_max = Integer.MIN_VALUE;
			work2_max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}//loop 끝
			//1. 어느 벌집을 채취할질 탐색
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n-m+1; j++) {
					worker1 = new int[m][2];
					for (int k = 0; k < m; k++) {
						worker1[k] = new int[] {i,j+k};
						visit[i][j+k] = true;
//						System.out.println("worker1  "+ worker1[k][0]+" "+worker1[k][1]);
					}
					for (int i2 = 0; i2 < n; i2++) {
						for (int j2 = 0; j2 < n-m+1; j2++) {
							worker2 = new int[m][2];
							boolean chk = false;
							for (int k = 0; k < m; k++) {
								if(visit[i2][j2+k]) break;
								worker2[k] = new int[] {i2,j2+k};
								chk = true;
//								System.out.println("worker2  "+ worker2[k][0]+" "+worker2[k][1]);
							}
							//2. 벌꿀 얼마 채취할 수 있는지 조합으로 탐색
							if(chk) {
								chk1 = new boolean[m];
								chk2 = new boolean[m];
								gogoFindHoney(0,0);
							}
						}
					}
				}
			}
		}//tc 끝
	}//main 끝
	//c = 10
	static void gogoFindHoney(int step, int idx) {


	}

}
