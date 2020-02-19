import java.io.*;
import java.util.*;


public class Solution_모의SW역량테스트_디저트카페 {
	static int di[] = {1,1,-1,-1}, dj[] = {1,-1,-1,1},n,map[][],max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			max =0; 
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//각 지점에서 시작을 해본다.
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					move(i,j,new ArrayList<Integer>(), i,j, 0);
				}
			}
			if(max==0)System.out.println("#"+tc+" -1");
            else
            System.out.println("#"+tc+" "+max);
		}//tc 끝
	}//main 끝
	static void move(int sr, int sc, ArrayList<Integer> list, int r, int c, int dir) {
        
		//돌아옴
		if(dir==3 &&  r== sr && c==sc) {
//          System.out.println(list.size());
            if(list.size()>1) {
                max =Math.max(max, list.size());
            }
            return ;
        }
		
		
        int nr = r+di[dir];
        int nc = c+dj[dir];
        

        if(check(nr,nc)&& !list.contains(map[nr][nc])) {
//          System.out.println(map[nr][nc]);
            list.add(map[nr][nc]);
            move(sr,sc,list,nr,nc,dir);
            list.remove(list.size()-1);
        }
        if(dir<3) {
            nr = r+di[dir+1]; 
            nc = c+dj[dir+1];
            if(check(nr,nc)&& !list.contains(map[nr][nc])) {
                list.add(map[nr][nc]);
                move(sr,sc,list,nr,nc,dir+1);
                list.remove(list.size()-1);
            }
        }
    }
     
    static boolean check(int r, int c) {
        return r>=0 && c>=0 && r<n && c<n;
    }
}
