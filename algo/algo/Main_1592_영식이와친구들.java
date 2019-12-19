package algo;

import java.util.Scanner;
 
public class Main_1592_영식이와친구들 {
    
    static int n,m,l;
    static int[] map;
    static int cur, next;
    static int res;
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        
        map = new int[n];
        
        while(true) {
            if(++map[cur] == m) break;
            
            if(map[cur] % 2 == 0) {
                next = cur + l >= n ? l - (n - cur) : cur + l;
            }
            else {
                next = cur - l < 0 ? n - (l - cur) : cur - l;  
            }
            cur = next;
            res++;
        }
        System.out.println(res);
    }
}