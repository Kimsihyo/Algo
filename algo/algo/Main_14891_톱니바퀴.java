package algo;
import java.io.*;
import java.util.*;

public class Main_14891_톱니바퀴 {
	static char cir[][];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		cir = new char[4][8];
		for (int i = 0; i < 4; i++) {
			cir[i] = sc.next().toCharArray();
//			System.out.println(Arrays.toString(cir[i]));
		} // 톱니바퀴 입력
			// 1-2 와 2-6, 2-2와 3-6, 3-2와 4-6
		int n = sc.nextInt();
		int where = 0;
		int dir = 0;
		for (int i = 0; i < n; i++) {
			// 입력 하자
			where = sc.nextInt();
			dir = sc.nextInt();
			// 이동할 수 있는 톱니바퀴 검사
			boolean chk1 = false;
			boolean chk2 = false;
			boolean chk3 = false;
			boolean chk4 = false;
			if (where == 1)
				chk1 = true;
			else if (where == 2)
				chk2 = true;
			else if (where == 3)
				chk3 = true;
			else if (where == 4)
				chk4 = true;
			// 1번 시계
			if (where == 1 && dir == 1) {
				if (cir[0][2] != cir[1][6])
					chk2 = true;
				if (cir[1][2] != cir[2][6])
					chk3 = true;
				if (cir[2][2] != cir[3][6])
					chk4 = true;
				move(0);
				if (chk2) {// 2번은 반시계로 움직임
					rmove(1);
					if (chk3) {// 3번은 시계로 움직임
						move(2);
						if (chk4) {
							rmove(3);
						}
					}
				}
			}
			// 1번 반시계
			else if (where == 1 && dir == -1) {
				if (cir[0][2] != cir[1][6])
					chk2 = true;
				if (cir[1][2] != cir[2][6])
					chk3 = true;
				if (cir[2][2] != cir[3][6])
					chk4 = true;
				rmove(0);
				if (chk2) {// 시계
					move(1);
					if (chk3) {// 반시계로 움직임
						rmove(2);
						if (chk4) {
							move(3);
						}
					}
				}
			}
			// 2번 시계
			else if (where == 2 && dir == 1) {
				if (cir[0][2] != cir[1][6])
					chk1 = true;
				if (cir[1][2] != cir[2][6])
					chk3 = true;
				if (cir[2][2] != cir[3][6])
					chk4 = true;
				move(1);
				if (chk1) {// 반
					rmove(0);
				}

				if (chk3) {// 반
					rmove(2);
					if (chk4) {
						move(3);
					}
				}
			}
			// 2번 반시계
			else if (where == 2 && dir == -1) {
				if (cir[0][2] != cir[1][6])
					chk1 = true;
				if (cir[1][2] != cir[2][6])
					chk3 = true;
				if (cir[2][2] != cir[3][6])
					chk4 = true;
				rmove(1);
				if (chk1) {// 반
					move(0);
				}

				if (chk3) {// 반
					move(2);
					if (chk4) {
						rmove(3);
					}
				}
			}
			// 3번 시계
			else if (where == 3 && dir == 1) {
				if (cir[0][2] != cir[1][6])
					chk1 = true;
				if (cir[1][2] != cir[2][6])
					chk2 = true;
				if (cir[2][2] != cir[3][6])
					chk4 = true;
				move(2);
				if (chk2) {
					rmove(1);
					if (chk1) {
						move(0);
					}
				}
				if (chk4) {
					rmove(3);
				}
			}
			// 3번 반시계
			else if (where == 3 && dir == -1) {
				if (cir[0][2] != cir[1][6])
					chk1 = true;
				if (cir[1][2] != cir[2][6])
					chk2 = true;
				if (cir[2][2] != cir[3][6])
					chk4 = true;
				rmove(2);
				if (chk2) {
					move(1);
					if (chk1) {
						rmove(0);
					}
				}
				if (chk4) {
					move(3);
				}
			}
			// 4번 시계
			else if (where == 4 && dir == 1) {
				if (cir[0][2] != cir[1][6])
					chk1 = true;
				if (cir[1][2] != cir[2][6])
					chk2 = true;
				if (cir[2][2] != cir[3][6])
					chk3 = true;
				move(3);
				if (chk3) {
					rmove(2);
					if (chk2) {
						move(1);
						if (chk1) {
							rmove(0);
						}
					}
				}
			}
			// 4번 반시계
			else if (where == 4 && dir == -1) {
				if (cir[0][2] != cir[1][6])
					chk1 = true;
				if (cir[1][2] != cir[2][6])
					chk2 = true;
				if (cir[2][2] != cir[3][6])
					chk3 = true;
				rmove(3);
				if (chk3) {
					move(2);
					if (chk2) {
						rmove(1);
						if (chk1) {
							move(0);
						}
					}
				}
			}

		} // 돌려 돌려 톱니바퀴
		int sum = 0;
		if (cir[0][0] == '1') {
			sum += 1;
		}
		if (cir[1][0] == '1') {
			sum += 2;
		}
		if (cir[2][0] == '1') {
			sum += 4;
		}
		if (cir[3][0] == '1') {
			sum += 8;
		}
		System.out.println(sum);
	}

	// 시계방향 이동
	static void move(int num) {
		char temp = cir[num][7];
		cir[num][7] = cir[num][6];
		cir[num][6] = cir[num][5];
		cir[num][5] = cir[num][4];
		cir[num][4] = cir[num][3];
		cir[num][3] = cir[num][2];
		cir[num][2] = cir[num][1];
		cir[num][1] = cir[num][0];
		cir[num][0] = temp;
	}

	// 반시계 이동
	static void rmove(int num) {
		char temp = cir[num][0];
		cir[num][0] = cir[num][1];
		cir[num][1] = cir[num][2];
		cir[num][2] = cir[num][3];
		cir[num][3] = cir[num][4];
		cir[num][4] = cir[num][5];
		cir[num][5] = cir[num][6];
		cir[num][6] = cir[num][7];
		cir[num][7] = temp;

	}

}
