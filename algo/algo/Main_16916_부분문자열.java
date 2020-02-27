package algo;
import java.io.*;
import java.io.*;
import java.util.*;

public class Main_16916_부분문자열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String p = br.readLine();
		char[] arr = new char[s.length()];
		arr = s.toCharArray();
		
		char[] arr2 = new char[p.length()];
		arr2 = p.toCharArray();
		
		boolean[] chk = new boolean[p.length()];
here:		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == arr2[0]) {
				chk[0] = true;
				for (int j = 1; j < arr2.length; j++) {
					if(i+j>=arr.length) break;
					if(arr[i+j] == arr2[j]) {
						chk[j] = true;
						if(j == arr2.length-1) {
							break here;
						}
					}else {
						chk[j] = false;
					}
				}
			}
		}
		boolean ans = true;
		for (int i = 0; i < chk.length; i++) {
			if(!chk[i]) {
				ans = false;
			}
		}
		if(ans) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}

}
