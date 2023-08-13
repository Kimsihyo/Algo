import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] c = a.toCharArray();
        
        for(int i=0; i<c.length; i++){
             if(Character.isLowerCase(c[i])){
                 System.out.print(Character.toUpperCase(c[i]));
             }else{
                 System.out.print(Character.toLowerCase(c[i]));
             }
        }
    }
}