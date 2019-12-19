package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class Main_2668_숫자고르기 {
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list;
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            visited[i] = true;    
            dfs(i,i);
            visited[i] = false; 
        }
        Collections.sort(list);    
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);    
        }
    }
 
    public static void dfs(int startnode,int currentnode) {
        
        if (!visited[arr[startnode]]) {     
            visited[arr[startnode]] = true;     // 방문했으므로 true
            dfs(arr[startnode],currentnode);
            visited[arr[startnode]] = false; // 다음 DFS들을 위하여 false
        }
        if (arr[startnode] == currentnode) {    //마지막 점이 출발점과 같다면 사이클이 완성됐으므로 리스트에 추가
            list.add(currentnode);
        }
    }
}
