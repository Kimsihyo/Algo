package algo;
import java.io.*;
import java.util.*;

public class Solution_D3_9480_민정이와광직이의알파벳공부{
	static int n, answer;
	static String[] words;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T  = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			words = new String[n];
			chk = new int[n];
			answer = 0;
			for (int i = 0; i < n; i++) {
				words[i] = sc.next();
			}
	        for(int i = 1 ; i <= n ; i++) {
	            dfs(0,0,i);
	        }
			
			
		}//tc 끝
	}//main 끝
	
	static void dfs(int idx, int deep, int target) {
        if(deep == target) {
            if(inspecAllAlphabet(getAllPickStr(deep))) answer++;
            return;
        }
        for(int i = idx ; i < n ; i++) {
            chk[deep] = i;
            dfs(i+1,deep+1,target);
        }
		
	}//dfs 끝
    public static String getAllPickStr(int deep) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < deep ; i++) {
            sb.append(words[chk[i]]);
        }
        return sb.toString();
    }
    private static boolean inspecAllAlphabet(String pStr) {
        char alphabet = 'a';
        for(int i = 0 ; i <= 26 ; i++) {
            if(pStr.indexOf(alphabet+i) < 0) return false;
        }
        return true;
    }
}