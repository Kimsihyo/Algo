/*
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
	아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

 */
import java.util.*;
public class Main_11726_2xN타일링_for문 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int num = sc.nextInt();
    	int [] array = new int[1001];
    	array[0] =1;
    	array[1] =1;
    	for(int i=2; i<=num; i++) {
    		array[i] = array[i-1] + array[i-2];
    		array[i] = array[i]%10007;
    	}
    	System.out.println(array[num]);
    	sc.close();
	}
}

// 재귀로는 ??????