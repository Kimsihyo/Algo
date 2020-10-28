import java.io.*;
import java.util.*;

public class Main_17143_낚시왕 {
	static int map[][], x, y;
	static ArrayList<int[]> shark;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		int sharkCnt = sc.nextInt();
		map = new int[x][y];
		int[][] tmap = new int[x][y];
		shark = new ArrayList<int[]>();
		for (int i = 0; i < sharkCnt; i++) {
			int sx = sc.nextInt()-1;
			int sy = sc.nextInt()-1;
			int v = sc.nextInt();
			int d = sc.nextInt();
			int s = sc.nextInt();
			map[sx][sy] = s;
			shark.add(new int[]{sx,sy,v,d,s});
		}
//		int[] temp1 = shark.remove(7);
//		System.out.println(temp1[0] + " " + temp1[1]+ " " +temp1[2] + " " + temp1[3] + " "+ temp1[4]);

		int ans = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if(map[i][j] != 0) {
					ans += map[i][j];
					map[i][j] = 0;
					break;
				}//낚시 end
				//방향 1 위, 2아래, 3오른쪽, 4왼쪽
				tmap = new int[x][y];
				int size = shark.size();// 상어를 하나씩 움직여보자
				System.out.println("----------------");
				for (int k = 0; k < size; k++) {
					int[] temp = shark.remove(0);
					System.out.println(temp[0]+ " "+temp[1]+ " "+temp[2]+ " "+temp[3]+ " "+temp[4]);
					int nx = temp[0];
					int ny = temp[1];
					int vec = temp[2];
					int dir = temp[3];
					int s = temp[4];
					int cnt = 0;
					
					if(map[nx][ny] != 0 && s != map[nx][ny]) {
						continue;
					}
					
					while(cnt == vec) {
						cnt++;
						if(dir == 1) {
							nx-=1;
							if(nx == -1) {
								dir = 2;
								nx = 1;
							}
						}
						else if(dir == 2) {
							nx +=1;
							if(nx == x) {
								dir = 1;
								nx = x-2;
							}
						}
						else if(dir == 3) {
							ny -= 1;
							
						}
						else if(dir ==4) {
							ny += 1;
							
						}
						
					}
					if(tmap[nx][ny] != 0) {
						if(tmap[nx][ny] < s) {
							tmap[nx][ny] = s;
						}
					}else {
						tmap[nx][ny] = s;
					}
					shark.add(new int[] {nx,ny, vec, dir,s});
				}
				for (int k = 0; k < x; k++) {
					for (int k2 = 0; k2 < y; k2++) {
						map[k][k2] = tmap[k][k2];
					}
				}
			}
		}
		System.out.println(ans);
	}// main end
}
