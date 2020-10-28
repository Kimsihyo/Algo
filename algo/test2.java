import java.util.*;

class test2 {
	public static void main(String args[]) throws Exception {
		String text = "((아디다스) 무료 (나이키 (풋살화)) 배송) 강남점 (축구)(잔디)";
		char[] arr = text.toCharArray();
		int cnt = 0;
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
				if (temp != "") {
					temp += " " + cnt + " ";
				}
				cnt++;
			} else if (arr[i] == ')' || arr[i] == '}' || arr[i] == ']') {
				temp += " " + cnt + " ";
				cnt--;

			} else if (arr[i] != ' ') {
				temp += arr[i];
			}
		}
		System.out.println(temp);
		String[] sarr = temp.split(" ");
		System.out.println(Arrays.toString(sarr));
	}
}