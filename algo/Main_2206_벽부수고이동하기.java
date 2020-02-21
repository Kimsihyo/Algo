import java.io.*;
import java.util.*;

public class Main_2206_벽부수고이동하기 {
    static int N,M;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int min;
    static boolean ok;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M][2];
        
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[j] -'0';
            }
        }
        visited[0][0][1] = true;
        q.add(new Node(0, 0, 1));
        
        loop :while(!q.isEmpty()) {
            int size = q.size();
            
            for (int s = 0; s < size; s++) {
                Node cur = q.poll();
                if(cur.x == N-1 && cur.y == M-1) {
                    min++;
                    ok = true;
                    break loop;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x +dx[i];
                    int ny = cur.y +dy[i];
                    
                    if(!isRange(nx, ny)) continue;
                    
                    // 벽이라면
                    if(map[nx][ny] == 1) {
                        // 드릴을 가지고 있고, 방문한적이 없다면 (벽으로 이동시에 드릴은 무조건 0임..)
                        if(cur.d > 0 && !visited[nx][ny][0]) {
                            visited[nx][ny][0] = true;
                            q.add(new Node(nx, ny, 0));
                        }
                    }
                    else {
                        if(visited[nx][ny][cur.d])
                            continue;
                        visited[nx][ny][cur.d] = true;
                        q.add(new Node(nx, ny, cur.d));
                    }
                }
            }
            min++;
        }
        System.out.println(ok ? min : -1);
    }
    
    static boolean isRange(int x, int y) {
        if ( x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }
}
class Node {
    int x;
    int y;
    int d;
    
    Node(int x, int y , int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}