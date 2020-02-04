/*
 * 궁수 3명 한 턴에 한명 공격
 * 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 
 * 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다.
 * 같은 적이 여러 궁수에게 공격당할 수 있다.
 * 궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며, 
 * 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 
 * 모든 적이 격자판에서 제외되면 게임이 끝난다. 
 
 1. 화살을 쏜다.
 	1. 가까운 적을 찾는다.
 	2. 같은 거리면 왼쪽에 있는 놈 먼저 죽인다.
 		1.
 2. 제외시킨다,
 3. 이동한다.
 
 */
import java.util.*;

public class Main_17135_캐슬디펜스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt(); // 사거리
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
	}

}
