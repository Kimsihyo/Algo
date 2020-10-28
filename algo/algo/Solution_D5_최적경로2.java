package algo;
import java.io.*;
import java.util.*;

public class Solution_D5_최적경로2 {
	
	static int N;// 고객의 집 수
	static int min, CX,CY,HX,HY;
	static int customer[][];
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			customer = new int[N][2];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			CX = Integer.parseInt(st.nextToken());
			CY = Integer.parseInt(st.nextToken());
			HX = Integer.parseInt(st.nextToken());
			HY = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			go(0,0,CX,CY,0);
			System.out.println("#" +tc + " "+min);
		}//tc 끝
		
	}//main 끝
    private static void go(int count, int visited, int bx, int by, int result) {
    	if(result >= min) return; //가지 치기 : 기존까지 순열로 처리 중인 고객들까지 이동했던 거리가 기존 Min 값보다 크다면 
    							 //          더이상 고객집을 방문해도 이동거리는 커질 수 밖에 없으므로 가지치기
    	
    	if(count == N) { // 기저 조건
    		result += Math.abs(bx-HX) + Math.abs(by-HY);
    		if(min > result) {
    			min = result;
    		}
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {//모든 고객 집을 다 count 위치에 시도
			if((visited & 1<<i) == 0) { // visited & 1<<i : i 고객집이 기존 순열에 처리되었는지 확인 : 
										// 0 -> 처리 안됨, 
										// 0이 아님 -> 처리되었음
				//visited | (1<<i) : 기존의 순열상태에 i고객집 추가
				go(count+1,visited | (1<<i), customer[i][0], customer[i][1],
						result + Math.abs(bx - customer[i][0] + Math.abs(by - customer[i][1])));
			}
    		
		}
    }
}
