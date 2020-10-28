package algo;
import java.util.Scanner;

public class Main_17822_원판돌리기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		int[][] cir = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cir[i][j] = sc.nextInt();
			}
		} // 원 입력loop end
		for (int i = 0; i < T; i++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int K = sc.nextInt();
			//돌리자
			for (int k = 0; k < K; k++) {
				if(d == 0) {// 시계방향
					int temp = cir[x-1][M-1];
					for (int j = 0; j < M; j++) {
						if(j == M-1) {
							cir[x-1][0] = temp;
						}else {
							cir[x-1][j+1] = cir[x-1][j];
						}
					}
				}else {// 반시계 방향
					int temp = cir[x-1][0];
					for (int j = 0; j < M; j++) {
						if(j == M-1) {
							cir[x-1][M-1]= temp;
						}
						cir[x-1][j] = cir[x-1][j+1];
					}
				}
			}

//			for (int j = 0; j < N; j++) {
//				for (int j2 = 0; j2 < M; j2++) {
//					if(j == N-1) {
//						if(j2 == 0) {
//							
//						}
//					}
//				}
//			}
			
		} // 명령입력
		//인접수가 같은걸지운다  이프
		//인접수가 다르면 원판의 평균을 구하고  평균 > 수 + 1 평균 < 수 -1 엘스 
		int[][] tcir = new int[N][M];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tcir[i][j] = cir[i][j];
				sum += cir[i][j];
			}
		}//복사 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M ; j++) {
				//제일 바깥 
				if(i == N-1) {
					if(j == M-1 && cir[i][j] == cir[i][0]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i][0] != 0) {
							sum-=cir[i][0];
						}
						tcir[i][j] = 0;
						tcir[i][0] = 0;
						
						continue;
					}
					else if(cir[i][j] == cir[i][j+1]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i][j+1] != 0) {
							sum-=cir[i][j+1];
						}
						tcir[i][j] = 0;
						tcir[i][j + 1] = 0;
					}
					//밑
					else if(cir[i][j] == cir[i-1][j]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i-1][j] != 0) {
							sum-=cir[i-1][j];
						}
						tcir[i][j] = 0;
						tcir[i-1][j] = 0;
					}
				
				}
				//제일 안쪽 
				else if(i == 0) {
					if(j == M-1 && cir[i][j] == cir[i][0]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i][0] != 0) {
							sum-=cir[i][0];
						}
						tcir[i][j] = 0;
						tcir[i][0] = 0;
						continue;
					}
					else if(cir[i][j] == cir[i][j+1]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i][j+1] != 0) {
							sum-=cir[i][j+1];
						}
						tcir[i][j] = 0;
						tcir[i][j + 1] = 0;
					}
					//밑
					else if(cir[i][j] == cir[i+1][j]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i+1][j] != 0) {
							sum-=cir[i+1][j];
						}
						tcir[i][j] = 0;
						tcir[i+1][j] = 0;
					}
					
				}
				else {
					if(j == M-1 && cir[i][j] == cir[i][0]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i][0] != 0) {
							sum-=cir[i][0];
						}
						tcir[i][j] = 0;
						tcir[i][0] = 0;
						continue;
					}
					else if(cir[i][j] == cir[i][j+1]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i][j+1] != 0) {
							sum-=cir[i][j+1];
						}
						tcir[i][j] = 0;
						tcir[i][j + 1] = 0;
					}
					else if(cir[i][j] == cir[i+1][j]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i+1][j] != 0) {
							sum-=cir[i+1][j];
						}
						tcir[i][j] = 0;
						tcir[i+1][j] = 0;
					}
					//밑
					else if(cir[i][j] == cir[i-1][j]) {
						if(tcir[i][j] != 0) {
							sum-=cir[i][j];
						}
						if(tcir[i-1][j] != 0) {
							sum-=cir[i-1][j];
						}
						tcir[i][j] = 0;
						tcir[i-1][j] = 0;
					}

				}
			}
		}
		int avg = sum/(N+M);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tcir[i][j] != 0) {
					if(tcir[i][j] > avg) {
						tcir[i][j] -=1;
					}
					if(tcir[i][j]<avg) {
						tcir[i][j] += 1;
					}
				}
				ans = tcir[i][j];
			}
		}
		System.out.println(ans);
	}

}
