import java.util.*;

public class Main_3190_뱀 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1 ;
			map[x][y] = 1;
		}	
		Queue<int[]> list = new LinkedList<int[]>();
		list.add(new int[] {0,0});
		int l = sc.nextInt();
		String lot = "";
		for (int i = 0; i < l; i++) {
			int time = sc.nextInt(); 
			if(lot.contains(null)) {
				for (int j = 0; j < time; j++) { // 시간
					int size = list.size(); // 뱀 사이즈 
					for (int z = 0; z < size; z++) {
						int[] temp = list.remove();
						int x = temp[0];
						int y = temp[1];
						if(x<0 || y<0 || x>=n || y>=n) {
							break;
						}
						if(map[x][y+1] == 1) {
							list.add(new int[] {x,y+1});
							list.add(new int[] {x,y+1});
							break;
						}else {
							list.add(new int[] {x,y+1});
						}
					}
				}
			}
			
			
			
			lot = sc.next();
			
			
		}
	}

}
