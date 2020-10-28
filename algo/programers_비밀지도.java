import java.util.*;

public class programers_비밀지도 {
	
	    public String[] solution(int n, int[] arr1, int[] arr2) {
			char[][] map1 = new char[n][n];
			char[][] map2 = new char[n][n];
			String binaryString1 = "";
			String binaryString2 = "";
			for(int i=0; i<n; i++) {
				binaryString1 = Integer.toBinaryString(arr1[i]); // 2진수로 변환
				binaryString2 = Integer.toBinaryString(arr2[i]); // 2진수로 변환
				while(binaryString1.length() != n) {
					String s1 = "0";
					s1 += binaryString1;
					binaryString1 = s1;
				}// end of while loop
				while(binaryString2.length() != n) {
					String s2 = "0";
					s2 += binaryString2;
					binaryString2 = s2;
				}
				
				for(int j=0; j<n; j++) {
					map1[i][j] = binaryString1.charAt(j);
					map2[i][j] = binaryString2.charAt(j);
				}// end of for loop
			}// end of for loop
			String[] answer = new String[n];
			for (int i = 0; i < n; i++) {
				String s = "";
				for (int j = 0; j < n; j++) {
					if(map1[i][j] == '1' || map2[i][j] == '1') {
						s+="#";
					}else {
						s += " ";
					}
				}
				answer[i] = s;
			}
			// System.out.println(Arrays.toString(answer));
	        return answer;
	    }
}
