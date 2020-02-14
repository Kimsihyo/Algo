import java.util.Scanner;

/*
	1.현재 위치를 청소한다. 


2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
3.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
왼쪽에 쓰레기가 있으면 방향 회전

4.왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
없으면 방향 회전하고 쓰레기 있는지 확인

5.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.


6.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
*/
public class Main_14503_로봇청소기 {
	static int map[][], n, m;
	static boolean ruclean[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		int current_x = sc.nextInt();
		int current_y = sc.nextInt();
		int current_front = sc.nextInt();

		map = new int[n][m];
		// 벽이거나 청소하면 true로
		ruclean = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		clear(current_x, current_y, current_front);
	}

	static void clear(int x, int y, int dir) {
		// 왼쪽에 안한 곳이 있나요 ?

				if (dir == 0) {
					// 바라보는 방향이 북
					for (int z = y; z >= 0; z--) {
						if(!ruclean[x][z]) {
							ruclean[x][z]=true;
						}
					}
				} else if (dir == 1) {
					// 동
					for (int z = x; z >= 0; z--) {

					}
				} else if (dir == 2) {
					// 남
					for (int z = y; z < m; z++) {

					}

				} else if (dir == 3) {
					// 서
					for (int z = x; z < n; z++) {

						
						
					}



		}
	}
}
