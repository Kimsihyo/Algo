import java.util.*;

class test {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };
	static Queue<int[]> q;
	static boolean[][] visit;
	static char[][] tmap;
	static String answer;
	static int[] num;

	public static void main(String args[]) throws Exception {
		int N = 5;// 세로
		int M = 7;// 가로
		num = new int[26];
		String[] map = { "--*AB**", "AB*A*BA", "B*-A*BB", "*-A*A**", "BC*BC*C" };
		tmap = new char[N][M];
		visit = new boolean[N][M];
		q = new LinkedList<>();
		// 구역을 검사하면서 큐에 넣기
		for (int i = 0; i < N; i++) {
			tmap[i] = map[i].toCharArray();
		}
		answer = "";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {
					q.add(new int[] { i, j });
					visit[i][j] = true;
					check(N, M);
				}
			}
		}

		System.out.println(answer);
		// 구역이 정해지면 검사 싸움 죽여 카운트

	}

	static void check(int N, int M) {
		int[] number = new int[26];
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			if (tmap[x][y] != '-' && tmap[x][y] != '*') {
				if (tmap[x][y] == 'A') {
					number[0] += 1;
				} else if (tmap[x][y] == 'B') {
					number[1] += 1;
				} else if (tmap[x][y] == 'C') {
					number[2] += 1;
				} else if (tmap[x][y] == 'D') {
					number[3] += 1;
				} else if (tmap[x][y] == 'E') {
					number[4] += 1;
				} else if (tmap[x][y] == 'F') {
					number[5] += 1;
				} else if (tmap[x][y] == 'G') {
					number[6] += 1;
				} else if (tmap[x][y] == 'H') {
					number[7] += 1;
				} else if (tmap[x][y] == 'I') {
					number[8] += 1;
				} else if (tmap[x][y] == 'J') {
					number[9] += 1;
				} else if (tmap[x][y] == 'K') {
					number[10] += 1;
				} else if (tmap[x][y] == 'L') {
					number[11] += 1;
				} else if (tmap[x][y] == 'M') {
					number[12] += 1;
				} else if (tmap[x][y] == 'N') {
					number[13] += 1;
				} else if (tmap[x][y] == 'O') {
					number[14] += 1;
				} else if (tmap[x][y] == 'P') {
					number[15] += 1;
				} else if (tmap[x][y] == 'Q') {
					number[16] += 1;
				} else if (tmap[x][y] == 'R') {
					number[17] += 1;
				} else if (tmap[x][y] == 'S') {
					number[18] += 1;
				} else if (tmap[x][y] == 'T') {
					number[19] += 1;
				} else if (tmap[x][y] == 'U') {
					number[20] += 1;
				} else if (tmap[x][y] == 'V') {
					number[21] += 1;
				} else if (tmap[x][y] == 'W') {
					number[22] += 1;
				} else if (tmap[x][y] == 'X') {
					number[23] += 1;
				} else if (tmap[x][y] == 'Y') {
					number[24] += 1;
				} else if (tmap[x][y] == 'Z') {
					number[25] += 1;
				}
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + di[i];
				int ny = y + dj[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny] && tmap[nx][ny] != '*') {
					visit[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}

		}
		int max = -1;
		int temp = -1;
		String s = "";
		for (int i = 0; i < number.length; i++) {
			if (number[i] == 0)
				continue;
			if (max == number[i]) {// 여러개인경우
				number[i] = 0;
			}
			if (max < number[i]) {
				if(temp >= 0) {
					number[temp] = 0;
				}
				max = number[i];
				temp = i;
				

			}

		}
		System.out.println(Arrays.toString(number));
	}

}