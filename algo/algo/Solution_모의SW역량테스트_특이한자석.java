package algo;
import java.io.*;
import java.util.*;
/*
 하나의 자석이 1 칸 회전될 때, 붙어 있는 자석은 서로 붙어 있는 날의 자성과 다를 경우에만 인력에 의해 반대 방향으로 1 칸 회전된다.
- 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.
- 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.
- 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.
- 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.
2번 6번 확인
 */
public class Solution_모의SW역량테스트_특이한자석 {
	static int arr[][], lot_save[];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			arr = new int[4][8];
			lot_save = new int[4];//각 자석의 회전 방향 저장
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {// n번 회전 할거임
				//1번의 2와 2번의 6 확인 
				//2번의 2와 3번의 6 확인
				//3번의 2와 4번의 6 확인
				int lot_num = sc.nextInt()-1;
				lot_save = new int[4];//각 자석의 회전 방향 저장
				Arrays.fill(lot_save, 3);
				lot_save[lot_num] = sc.nextInt();//1 시계 -1 반시계 
				
				if(lot_num == 0) {
					zero();
					fir();
					sec();
					thi();
				}
				
				if(lot_num == 1) {
					fir();
					zero();
					sec();
					thi();
				}
				
				if(lot_num == 2) {
					sec();
					thi();
					fir();
					zero();
				}
				
				if(lot_num == 3) {
					thi();
					sec();
					fir();
					zero();
				}
				for (int j = 0; j < 4; j++) {
					if(lot_save[j]==1) {
						location(j);
					}else if(lot_save[j] == -1) {
						rivers(j);
					}
				}
			}
			//1 2 4 8
			int ans = 0;
			if(arr[0][0] == 1) {
				ans += arr[0][0];
			}
			if(arr[1][0] == 1) {
				ans += (arr[1][0]*2);
			}
			if(arr[2][0] == 1) {
				ans += (arr[2][0]*4);
			}
			if(arr[3][0] == 1) {
				ans += (arr[3][0]* 8);
			}
			System.out.println("#"+tc+" "+ans);
		}//tc 끝
	}//main 끝
	static void zero() {
		if(lot_save[1] == 3 && arr[0][2] == arr[1][6]) {//같으면 1은 가만히
			lot_save[1] = 0;
			
		}else {// 다르면 1은 
			if(lot_save[1] == 3 &&lot_save[0] == 1) {
				lot_save[1] = -1;
			}else if(lot_save[1] == 3 &&lot_save[0] == -1) {
				lot_save[1] = 1;
			}else if(lot_save[1] == 3 &&lot_save[0] == 0) {
				lot_save[1] = 0;
			}
		}
		
	}
	static void fir() {
		if(lot_save[2] == 3 &&arr[1][2] == arr[2][6]) {
			lot_save[2] = 0;
		}else {
			if(lot_save[2] == 3 &&lot_save[1] == 1) {
				lot_save[2] = -1;
			}else if(lot_save[2] == 3 &&lot_save[1] == -1) {
				lot_save[2] = 1;
			}else if(lot_save[2] == 3 &&lot_save[1] == 0) {
				lot_save[2] = 0;
			}
			
		}
		if(lot_save[0] == 3 &&arr[1][6] == arr[0][2]) {
			lot_save[0] = 0;
		}else {
			if(lot_save[0] == 3 &&lot_save[1] == 1) {
				lot_save[0] = -1;
			}else if(lot_save[0] == 3 &&lot_save[1] == -1) {
				lot_save[0] = 1;
			}else if(lot_save[0] == 3 &&lot_save[1] == 0) {
				lot_save[0] = 0;
			}
			
		}
	}
	static void sec() {
		if(lot_save[3] == 3 &&arr[2][2] == arr[3][6]) {
			lot_save[3] = 0;
		}else {
			if(lot_save[3] == 3 &&lot_save[2] == 1) {
				lot_save[3] = -1;
			}else if(lot_save[3] == 3 &&lot_save[2] == -1) {
				lot_save[3] = 1;
			}else if(lot_save[3] == 3 &&lot_save[2] == 0) {
				lot_save[3] = 0;
			}
			
		}
		if(lot_save[1] == 3 &&arr[2][6] == arr[1][2]) {
			lot_save[1] = 0;
		}else {
			if(lot_save[1] == 3 &&lot_save[2] == 1) {
				lot_save[1] = -1;
			}else if(lot_save[1] == 3 &&lot_save[2] == -1) {
				lot_save[1] = 1;
			}else if(lot_save[1] == 3 &&lot_save[2] == 0) {
				lot_save[1] = 0;
			}
			
		}
		
	}
	static void thi() {
		if(lot_save[2] == 3 &&arr[3][6] == arr[2][2]) {
			lot_save[2] = 0;
		}else {
			if(lot_save[2] == 3 &&lot_save[3] == 1) {
				lot_save[2] = -1;
			}else if(lot_save[2] == 3 &&lot_save[3] == -1) {
				lot_save[2] = 1;
			}else if(lot_save[2] == 3 &&lot_save[3] == 0) {
				lot_save[2] = 0;
			}
			
		}
		
	}
	
	static void location(int idx) {//시계 방향
		int temp = arr[idx][0];
		arr[idx][0] = arr[idx][7];
		arr[idx][7] = arr[idx][6];
		arr[idx][6] = arr[idx][5];
		arr[idx][5] = arr[idx][4];
		arr[idx][4] = arr[idx][3];
		arr[idx][3] = arr[idx][2];
		arr[idx][2] = arr[idx][1];
		arr[idx][1] = temp;
	}
	static void rivers(int idx) {// 반시계 방향
		int temp = arr[idx][0];
		arr[idx][0] = arr[idx][1];
		arr[idx][1] = arr[idx][2];
		arr[idx][2] = arr[idx][3];
		arr[idx][3] = arr[idx][4];
		arr[idx][4] = arr[idx][5];
		arr[idx][5] = arr[idx][6];
		arr[idx][6] = arr[idx][7];
		arr[idx][7] = temp;
	}
}
